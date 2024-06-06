package com.reptile.douban.chengdu;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;

/**
 * @className: chengduMain
 * @description: TODO 类描述
 * @author:
 * @date: 2022/12/9
 **/
public class chengduMain {
    public static void main(String[] args) {
        for (int i = 650; i < 1000; i+=50) {
            try {
                getDataList(i);
            } catch (IOException e) {
                System.err.println("起始页面"+i);
                throw new RuntimeException(e);
            }
        }
    }

    public static void getDataList(Integer offset) throws IOException{
        System. getProperties(). setProperty(" proxySet", "true");

        System . getProperties() . setProperty("http. proxyHost", "120.24.76.81");//代理Ip

        System. getProperties(). setProperty("http . proxyPort", "8123");//端口号

        String url = "https://www.douban.com/group/510977/discussion?start="+offset;
        Map cookieMap =new HashMap();
        cookieMap.put("dbcl2","180302866:a0+7YzPsfQk");
        Connection conn = Jsoup.connect(url).timeout(5000).cookies(cookieMap);
        conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        conn.header("Accept-Encoding", "gzip, deflate, sdch");
        conn.header("Accept-Language", "zh-CN,zh;q=0.8");   
        conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        Document document = conn.get();
        Elements rank =   document.select("a[title]");
        Elements rank2 =   document.getElementsByAttributeStarting("nowrap").select("a");
        Elements rank3 =   document.getElementsByClass("r-count");
        Elements rank4 =   document.getElementsByClass("time");
        List<blindDataListVo> blindDataListVoList = new LinkedList<>();
        for (Element link : rank) {

            System.out.println("href: " + link.attr("href"));
            System.out.println("title: " + link.attr("title"));
        }
        rank3.remove(0);
        for (int i = 0 ;i < rank.size();i++){
            blindDataListVo blindDataListVo = new blindDataListVo(rank.get(i).attr("title")
                    ,rank.get(i).attr("href"),rank2.get(i).text(),rank2.get(i).attr("href"),rank3.get(i).text(),rank4.get(i).text());
            blindDataListVoList.add(blindDataListVo);
        }
//        blindDataListVoList.forEach(System.out::println);
        int downloadCount = 0;
        for (blindDataListVo b:blindDataListVoList){
            Document d = Jsoup.connect(b.getTitleURL()).cookies(cookieMap).get();
            Elements r =  d.select("img[height]");
            for (Element e:r){
                downloadImg(b.getAuthor(),e.attr("src"));
                downloadCount++;
            }
        }
        System.out.println("成功下载图片次数"+downloadCount);
        System.err.println("当前下载的start"+offset);
    }
    public static void downloadImg(String fileName,String path) throws IOException {
        Connection connection = Jsoup.connect(path);
        Connection.Response response = null;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        response = connection.method(Connection.Method.GET).ignoreContentType(true).timeout(10 * 1000).execute();

        BufferedInputStream bufferedInputStream = response.bodyStream();

        System.out.println(response.contentType());
        saveFile(bufferedInputStream, "E:\\Development\\BackEnd\\Java\\Gitee\\JavaLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\douban\\chengdu\\img\\"+fileName+"——"+UUID.randomUUID()+".jpg");//保存文件的地址
    }
    //得到图片的二进制数据
    /**
     * 保存文件到本地
     * @param bufferedInputStream
     * @param savePath
     */
    public static void saveFile(BufferedInputStream bufferedInputStream,String savePath) {
     try {
         //一次最多读取1k
         byte[] buffer = new byte[1024];
         //实际读取的长度
         int readLenghth;
         //根据文件保存地址，创建文件输出流
         FileOutputStream fileOutputStream = new FileOutputStream(new File(savePath));
         //创建的一个写出的缓冲流
         BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
         //文件逐步写入本地
         while ((readLenghth = bufferedInputStream.read(buffer,0,1024)) != -1){//先读出来，保存在buffer数组中
             System.out.println(readLenghth);
             bufferedOutputStream.write(buffer,0,readLenghth);//再从buffer中取出来保存到本地
         }
         //关闭缓冲流
         bufferedOutputStream.close();
         fileOutputStream.close();
         bufferedInputStream.close();
     }catch (Exception e){
         e.printStackTrace();
     }
    }

}
