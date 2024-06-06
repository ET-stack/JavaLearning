package com.reptile.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.reptile.m3u8.DownFileUtil;
import com.reptile.m3u8.Video;
import com.reptile.mapper.VideoMapper;
import com.reptile.utils.RedisUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @className: testController
 * @description: TODO 类描述
 * @author: 
 * @date: 2022/8/15
 **/
@Controller
public class testController {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    VideoMapper videoMapper;

    @RequestMapping("test")
    public void test(){
        redisUtils.set("2","2");
        System.out.println(11);
    }

    @RequestMapping("test/download")
        public void download() throws IOException {
        String url = "https://www.cjii.xyz/1665675306964353024/index?filmName=&page.currentPage=4&target=&orderType=1&createTimeType="; //
        // 替换为您要获取的HTML页面的URL
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0"); // 设置User-Agent以避免被网站拒绝访问
        connection.connect();
        Document doc = Jsoup.parse(connection.getInputStream(), null, url);

        List<String> linkList = (extractHLSStrings(doc.data()));
        for (String s:linkList) {
            Video video = new Video();
          if (s.contains("spId")){
          }else {
              //https://la3.killcovid2021.com/m3u8/849555/849555.m3u8
              video.setUrl("https://la3.killcovid2021.com/m3u8/"+s+"/"+s+".m3u8");
              videoMapper.insert(video);
          }

        }
    }

    @RequestMapping("test/download1")
    public void download1() throws IOException {
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("download_status","0");
        List<Video> videoList = videoMapper.selectList(wrapper);
//      for (Video v:videoList){
//          DownFileUtil.run(v.getUrl());
//          v.setDownloadStatus(1);
//          videoMapper.updateById(v);
//      }
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (Video v : videoList) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                DownFileUtil.run(v.getUrl());
                v.setDownloadStatus(1);
                videoMapper.updateById(v);
            });
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    }
    public static List<String> extractHLSStrings(String input) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        String prefix = "https://cdn.bigcloud.cyou/hls/";
        while (true) {
            // 查找下一个以prefix开头的位置
            int prefixIndex = input.indexOf(prefix, startIndex);
            if (prefixIndex == -1) {
                // 如果没有找到，跳出循环
                break;
            }
            // 查找下一个/index.m3u8的位置
            int endIndex = input.indexOf("/index.m3u8", prefixIndex);
            if (endIndex == -1) {
                // 如果没有找到，跳出循环
                break;
            }
            // 提取中间的部分字符串
            String substring = input.substring(prefixIndex + prefix.length(), endIndex);
            result.add(substring);
            // 更新下一次查找的起始位置
            startIndex = endIndex + 1;
        }
        return result;
    }
}
