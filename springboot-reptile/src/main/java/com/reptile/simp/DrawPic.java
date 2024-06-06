package com.reptile.simp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @className: DrawPic
 * @description: TODO 类描述
 *
 * @date: 2022/11/8
 **/
public class DrawPic {

    public static void main(String[] args) {

        BufferedImage bi = new BufferedImage(487, 330, BufferedImage.TYPE_INT_RGB);

        final File file = new File("E:\\Development\\BackEnd\\Java\\Gitee\\JavaLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\simp\\wenzi.jpg");

        try {
            if(file.exists()) {
                file.delete();
                file.createNewFile();
            }
        }catch(IOException e) {
            e.printStackTrace();
        }


        writeImage(bi, "png", file);
        System.out.println("绘图成功");

    }

    /** 通过指定参数写一个图片  */
    public static boolean writeImage(BufferedImage bi, String picType, File file) {
        int width=487;
        int height=350;
        // 获取Graphics2D
        Graphics2D g2d = bi.createGraphics();

        // 增加下面代码使得背景透明
        bi = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        g2d.dispose();
        g2d = bi.createGraphics();
        // 背景透明代码结束

        // 画图BasicStroke是JDK中提供的一个基本的画笔类,我们对他设置画笔的粗细，就可以在drawPanel上任意画出自己想要的图形了。
        g2d.setColor(new Color(255, 255, 255));
        g2d.setStroke(new BasicStroke(1f));
        g2d.fillRect(128, 128, width, height);

        // 释放对象
        g2d.dispose();


        boolean val = false;
        try {
            val = ImageIO.write(bi, picType, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return val;
    }


}
