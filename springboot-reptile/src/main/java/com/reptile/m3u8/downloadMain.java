package com.reptile.m3u8;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className: downloadMain
 * @description: TODO 类描述
 * @author:
 * @date: 2022/12/16
 **/
public class downloadMain {
    public static void main(String[] args) throws IOException {
        String url = "https://www.cjii.xyz/1665675306964353024/index?filmName=&page.currentPage=4&target=&orderType=1&createTimeType="; // 替换为您要获取的HTML页面的URL
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0"); // 设置User-Agent以避免被网站拒绝访问
        connection.connect();
        Document doc = Jsoup.parse(connection.getInputStream(), null, url);


        System.out.println(extractHLSStrings(doc.data()).get(2));
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
