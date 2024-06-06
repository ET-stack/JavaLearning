package com.reptile.mingyantong;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * @className: mingyantongMain
 * @description: TODO 类描述
 * @author: 
 * @date: 2022/8/11
 **/
public class mingyantongJSOUPMain {

    public static void main(String[] args)  {

        getData(new ArrayList<>());


    }

    public static void getData(List<String> dataList) {

        for (int a = 0;a < 38;a++){
            String url = "https://www.mingyantong.com/article/373028?page="+a;
            Document document = null;
            try {
                document = Jsoup.connect(url).get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Elements links =  document.getElementsByClass("xlistju");

//            System.out.println(document.title());
            int i = 0;
            for (Element link : links) {
                i++;
                dataList.add(link.text());
//                data.put("test",link.text());
                System.out.println("Text: " + link.text());
            }

        }
    }
}
