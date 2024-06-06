package com.zhengqing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.*;

/**
 * @className: M3U8Factory
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/7/14
 **/
@Slf4j
public class M3U8Factory {

    private RestTemplate restTemplate = new RestTemplate();

    //外部输入参数
    private String title;//视频名字
    private String dir;//本地文件夹

    private String uri;//host地址
    private String m3u8;//m3u8原文件名+后缀
    private String m3u8Path;//m3u8本地保存路径

    // 下载拉勾key的请求参数
    private String cookie;
    private String code;
    private String vid;

    public void setM3u8(String m3u8Url, String title, String outPath) {
        this.uri = m3u8Url.substring(0, m3u8Url.lastIndexOf("/") + 1);
        this.m3u8 = m3u8Url.substring(m3u8Url.lastIndexOf("/") + 1);
        this.title = title;
        this.dir = outPath;
    }

    public void setParam(String cookie, String code, String vid) {
        this.cookie = cookie;
        this.vid = vid;
        this.code = code;
    }

    public void build() {
        init();
        downloadKey(); //下载key
        String m3u8Content = downloadM3U8();//下载m3u8文件
        downloadTs(m3u8Content); //下载ts
        //downloadTsThread(m3u8Content); //多线程下载
        updateM3U8File(); //修改m3u8
        merge(); //合并
    }

    private void init() {
        File directory = new File(dir);
        if (directory.exists() == true) {
            log.info("目录已存在");
        } else {
            directory.mkdirs();
            log.info("目录创建完成");
        }
    }

    /**
     * 下载m3u8文件，包含key的下载地址(如果有) 和 ts文件名
     */
    public String downloadM3U8() {
        log.info("-- 开始下载 m3u8 --");
        ResponseEntity<byte[]> forEntity = restTemplate.getForEntity(uri + m3u8, byte[].class);
        //log.info("m3u8 内容 = {}", new String(forEntity.getBody()));

        if (title == null) {
            m3u8Path = dir + "\\\\" + m3u8;
        } else {
            m3u8Path = dir + "\\\\" + title + ".m3u8";
        }
        File file = new File(m3u8Path);

        try {
            Files.write(file.toPath(), Objects.requireNonNull(forEntity.getBody(), "未获取到文件"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(forEntity.getBody());
    }

    public String downloadKey() {
        log.info("-- 开始下载 key --");
        String uri = "https://kaiwu.lagou.com/alikey?code={code}&vid={vid}&appId={appId}";
        String key = null;

        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        // params  如果有的话
        LinkedHashMap<String, String> param = new LinkedHashMap<>();
        param.put("code", code);
        param.put("vid", vid);
        param.put("appId", "big_course");

        // herders  如果有的话
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Mobile Safari/537.36");
        httpHeaders.add("cookie", cookie);
        HttpEntity<Object> request = new HttpEntity<>(httpHeaders);

        try {
            ResponseEntity<byte[]> entity = restTemplate.exchange(uri, HttpMethod.GET, request, byte[].class, param);
            key = new String(entity.getBody());
            log.info("key = {}", key);

            File file = new File(dir + "//key.key");
            Files.write(file.toPath(), Objects.requireNonNull(entity.getBody(), "未获取到文件"));
        } catch (HttpClientErrorException e) {
            log.info("非200请求 = {}", e);
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }
    //修改m3u8文件
    private void updateM3U8File() {
        String keyPath = dir + "\\\\key.key";
        log.info("-------------------------------------");
        log.info("keyPath = {}", keyPath);
        log.info("修改m3u8文件");

        File file = new File(m3u8Path);
        String line = null;
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#EXT-X-KEY")) {
                    line = "#EXT-X-KEY:METHOD=AES-128,URI=\"" + keyPath + "\"";
                }
                if (line.endsWith(".ts")) {//修改ts文件地址
                    //line = uri + line;  //在线
                    line = dir + "\\\\" + line; //本地
                }
                stringBuffer.append(line + "\n");
            }
            //System.out.println("stringBuffer: " + stringBuffer);
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(stringBuffer.toString());
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //获取ts文件名
    public List<String> getTsList(String m3u8Content) {
        List<String> tsList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(m3u8Content.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                if (line.endsWith("ts")) {
                    tsList.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tsList.forEach(System.out::println);
        return tsList;
    }

    //下载ts文件
    public void downloadTs(String m3u8Content) {
        List<String> tsList = getTsList(m3u8Content);
        long startTime = System.currentTimeMillis();//开始时间

        for (String name : tsList) {
            ResponseEntity<byte[]> forEntity = restTemplate.getForEntity((uri + name), byte[].class);
            //System.out.println("结果 = " + forObject);
            File file = new File((dir + "//" + name));
            try {
                Files.write(file.toPath(), Objects.requireNonNull(forEntity.getBody(), "未获取到文件"));
                log.info("写入文件 = {}", file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();//结束时间
        log.info("ts文件下载耗时:" + (endTime - startTime) + "ms");
    }

    public void merge() {
        //例子：FfmpegUtils.mergeVedio("D:\\下载m3u8\\index.m3u8","D:\\下载m3u8\\new.flv");
        log.info("-------------------------------------");
        log.info("输入地址 = {}", m3u8Path);
        log.info("输出地址 = {}", dir + "\\\\" + title + ".mp4");
        log.info("开始合成");
        FfmpegUtils.mergeVedio(m3u8Path, dir + "\\\\" + title + ".mp4");
    }


}
