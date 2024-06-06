package com.reptile.img;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.regex.Pattern;

/**
 * @className: youNameImg
 * @description: TODO 类描述
 * @author: 
 * @date: 2022/10/12
 **/
public class youNameImg {
    public void getDoc(int page) throws IOException {
        File f = new File("E:\\imgs");

        if (!f.exists()) {
            f.mkdirs();
        }
//        int page = 6;
        String picUrl = "https://wall.alphacoders.com/by_sub_category.php?id=239404&name=Your+Name.+Wallpapers&quickload=1300+&page="+page;
        Document doc = Jsoup.connect(picUrl).get();
        Elements elements = doc.getElementsByTag("picture");
        Elements imgs = elements.select("img[src$=.png]");
        Elements links = doc.getElementsByClass("img-responsive thumb-desktop");
        int count = 1;
        for (Element e : imgs) {
                String src = e.absUrl("src");
                String imageName = "page_"+page+"no_"+ count+src.substring(src.lastIndexOf("/") +1, src.length());
                URL url = new URL(src);
                URLConnection uri = url.openConnection();
                uri.addRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");
                InputStream is = uri.getInputStream();
                OutputStream os = new FileOutputStream(new File("E:\\Development\\BackEnd\\Java\\Gitee\\SpringBootLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\img", imageName));

                byte[] buf = new byte[1024];
                int len = -1;

                while ((len = is.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
            }

    }

    public static void main(String[] args) throws IOException {
        for (int i = 0;i < 10;i++){
            new youNameImg().getDoc(i);
        }
    }

}