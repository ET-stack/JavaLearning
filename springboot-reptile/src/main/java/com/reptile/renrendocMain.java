package com.reptile;

import com.reptile.utils.ImagesUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @className: renrendocMain
 * @description: TODO 类描述
 * @author:
 * @date: 2023/1/10
 **/
public class renrendocMain {
    public static void main(String[] args) throws IOException {
        String url = "https://www.renrendoc.com/paper/224603259.html";
        Document document = Jsoup.connect(url).get();
        Elements links = document.getElementsByClass("page");
        int i = 0;
        String imgSrc = "";
        for (Element link : links) {

            for (Element l: link.children()){
                if (i == 0){
                    System.out.println("Text: " +l.attr("src"));
                    imgSrc = l.attr("src");
                }else {
                    System.out.println("Text: " +l.attr("data-original"));
                    imgSrc = l.attr("data-original");

                }
                ImagesUtil.download(imgSrc,"C:\\Users\\xiao\\Desktop\\img\\"+links.get(0).children().get(0).attr("alt")+i+".gif");
                i++;
            }


        }
    }
}
