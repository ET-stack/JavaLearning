package com.reptile.sls66_xyz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @className: main
 * @description: TODO 类描述
 * @author:
 * @date: 2023/3/14
 **/
public class main {
    public static void main(String[] args) throws IOException {
//        String url = "https://www.sls66.xyz/index.php/vod/type/id/50.html";

        String url = "https://cl.7807y.xyz/thread0806.php?fid=25&search=576343&page=1";
        Document document = Jsoup.connect(url).get();
        Elements links2 =  document.getElementsByClass("tal");
        System.out.println();
    }
}
