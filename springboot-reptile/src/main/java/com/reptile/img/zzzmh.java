package com.reptile.img;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @className: zzzmh
 * @description: TODO 类描述
 * @author:https://bz.zzzmh.cn/search
 * @date: 2023/7/21
 **/
public class zzzmh {
    public static void main(String[] args) {

    }
    public void getImage(int page) throws IOException {
        Document doc = Jsoup.connect("https://example.com").get();
        Element img = doc.selectFirst("img.v-image__image.v-image__image--cover");
        String imgUrl = img.attr("src");

        URL url = new URL(imgUrl);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get("image.jpg"), StandardCopyOption.REPLACE_EXISTING);
        in.close();
    }
}
