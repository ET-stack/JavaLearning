package com.reptile;

import com.reptile.utils.RedisUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReptileApplicationTests {
    @Autowired
    RedisUtils redisUtils;

    @Test
    public void contextLoads() throws IOException {
        for (int a = 0;a < 52;a++){
            String url = "https://www.mingyantong.com/writer/%E5%BE%90%E5%BF%97%E6%91%A9?page="+a;
            Document document = Jsoup.connect(url).get();
            Elements links =  document.getElementsByClass("xlistju");
//            System.out.println(document.title());
            for (Element link : links) {

                System.out.println("Text: " + link.text());
                redisUtils.set(link.baseUri(),link.text());
            }

        }
    }

}
