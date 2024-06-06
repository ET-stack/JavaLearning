package com.quartz.task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @className: cj02
 * @description: TODO 类描述
 * @date: 2023/4/17
 **/
public class cj02 {




    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("https://cj02.xyz/0/index?target=&subjectId=0&createTimeType=&filmName=%E5%B0%84%E7%B2%BE%E7%AE%A1%E7%90%86").get();
        Elements links = document.select("a[href]");
        for (Element e:links){
            System.out.println(e);
        }



    }
}
