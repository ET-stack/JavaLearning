package com.reptile.douban.chengdu;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className: testHH
 * @description: TODO 类描述
 * @author:
 * @date: 2022/12/11
 **/
public class testHH {
    public static void trustEveryone() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new X509TrustManager[] { new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            } }, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://18av1.cyou/index.php/vod/play/id/15357/sid/1/nid/1.html";
        String url2 = "https://video2.youxijian.com:8091/20200502/rReKITuq/index.m3u8";
        trustEveryone();
        Connection con = Jsoup.connect(url2).ignoreContentType(true);
        con.header("Accept", "text/html, application/xhtml+xml, */*");
        con.header("Content-Type", "application/x-www-form-urlencoded");
        con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
//        Thread.sleep(5000);
        System.out.println(con.get());


        Document document = Jsoup.connect(url).get();
        String regEx ="htt.*index.m3u8";

        Pattern pattern = Pattern.compile(regEx);
        Elements rank =   document.getElementsByTag("script");
        for (Element n: rank){
           Matcher matcher = pattern.matcher(n.toString());
           if (matcher.find()){
               System.out.println(matcher.group().replaceAll("\\\\",""));
           }

        }
    }
}
