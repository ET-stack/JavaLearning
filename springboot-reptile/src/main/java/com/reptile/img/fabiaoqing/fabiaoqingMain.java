package com.reptile.img.fabiaoqing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * @className: fabiaoqingMain
 * @description: TODO 类描述
 * @author: 
 * @date: 2022/10/14
 **/
public class fabiaoqingMain {
    public void getDoc() throws IOException {
        File f = new File("E:\\imgs");

        if (!f.exists()) {
            f.mkdirs();
        }
        int page = 2;
        String picUrl = "https://fabiaoqing.com/biaoqing/lists/page/"+page+".html";
        Document doc = Jsoup.connect(picUrl).get();
        Elements elements = doc.getElementsByTag("ui image lazy");
        Elements imgs = elements.select("img[src$=.png]");
        Elements links = doc.getElementsByClass("ui image lazy");
        int count = 1;
        for (Element e : links) {
            String src = e.absUrl("src");
            String imageName = "page_"+page+"no_"+ count+++src.substring(src.lastIndexOf("/") +1, src.length());
            URL url = new URL(src);
            URLConnection uri = url.openConnection();
            uri.addRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");
            InputStream is = uri.getInputStream();
            OutputStream os = new FileOutputStream(new File("E:\\Development\\BackEnd\\Java\\Gitee\\SpringBootLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\img\\fabiaoqing", imageName));

            byte[] buf = new byte[1024];
            int len = -1;

            while ((len = is.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new fabiaoqingMain().getDoc();
    }

}
