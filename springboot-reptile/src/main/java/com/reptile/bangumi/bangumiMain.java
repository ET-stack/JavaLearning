package com.reptile.bangumi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @className: bangumiMain
 * @description: TODO 类描述
 * @author: 
 * @date: 2022/10/12
 **/
public class bangumiMain {
    public static void main(String[] args) throws IOException {

        String url = "https://bangumi.tv/book/tag/%E7%8C%8E%E5%A5%87/?sort=rank&page=2";
        Document document = Jsoup.connect(url).get();
        Element links =  document.getElementById("browserItemList");
        Elements links2 =  links.getElementsByClass("l");
        Elements rank = links.getElementsByClass("rank");
//            System.out.println(document.title());
        for (Element link : links2) {

            System.out.println("Text: " + link.text());
        }

    }

}
