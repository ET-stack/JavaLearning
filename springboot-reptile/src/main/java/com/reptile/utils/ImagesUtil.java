package com.reptile.utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

/**
 *图片下载的公共方法
 * @author rp
 */
public class ImagesUtil {
    public static void download(String urlString, String filename)  {
        // 构造URL
        URL url = null;
        try {
            url = new URL(urlString);
            // 打开连接
            URLConnection con = url.openConnection();
            // 输入流
            InputStream is = con.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            OutputStream os = new FileOutputStream(filename);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        download("https://file2.renrendoc.com/fileroot_temp3/2021-5/29/7f3190c1-97a0-4579-baca-b550cdfd513b/7f3190c1-97a0-4579-baca-b550cdfd513b1.gif","222.gif");
    }

}