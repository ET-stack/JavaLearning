package com.reptile.douban.chengdu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className: douban2
 * @description: TODO 类描述
 * @author:
 * @date: 2023/4/26
 **/
public class douban2 {
    public static void main(String[] args) throws IOException {
//        Document document = Jsoup.connect("https://movie.douban.com/celebrity/1276086/").get();
//        Elements rank =   document.getElementsByClass("info");
//        for (Element e:rank){
//            System.out.println(e.text());
//        }
        String text = "演员 Actor (饰 刘培强)\n" +
                "演员 Actor (饰 王磊)\n" +
                "演员 Actress (饰 韩朵朵)\n" +
                "配音 Voice (配 岩户铃芽(童年))";

        Pattern pattern = Pattern.compile("\\((.+?)\\)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
