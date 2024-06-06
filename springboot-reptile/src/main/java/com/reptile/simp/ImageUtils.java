package com.reptile.simp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * @className: ImageUtils
 * @description: TODO 类描述
 * @author:
 * @date: 2022/11/8
 **/
public class ImageUtils {
    public static void margeImage(String path1,String path2,String outPath){
        try {
            BufferedImage image1 = ImageIO.read(Files.newInputStream(Paths.get(path1)));
            BufferedImage image2 = ImageIO.read(Files.newInputStream(Paths.get(path2)));
            int width = Math.max(image1.getWidth(), image2.getWidth());
            int heigth = image1.getHeight() + image2.getHeight();
            BufferedImage bufferedImage = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_BGR);
            Graphics g = bufferedImage.getGraphics();
            g.drawImage(image1, 0, 0, image1.getWidth(), image1.getHeight(),null);
            g.drawImage(image2, 0, image1.getHeight()-100, image2.getWidth(), image2.getHeight(),null);
            g.dispose();
            ImageIO.write(bufferedImage, "jpg", new File(outPath));
        } catch (Exception e) {
            System.err.println("合并照片失败");
        }
    }

    /**
     * 待合并的两张图必须满足这样的前提，如果水平方向合并，则高度必须相等；如果是垂直方向合并，宽度必须相等。
     * mergeImage方法不做判断，自己判断。      * @param img1 待合并的第一张图
     * @param img2 带合并的第二张图
     * @param isHorizontal 为true时表示水平方向合并，为false时表示垂直方向合并
     * @return 返回合并后的BufferedImage对象
     * @throws IOException
     */
    public static BufferedImage mergeImage(String path1,String path2,String outPath ,boolean isHorizontal) throws IOException {
        BufferedImage img1 = ImageIO.read(Files.newInputStream(Paths.get(path1)));
        BufferedImage img2 = ImageIO.read(Files.newInputStream(Paths.get(path2)));
        int w1 = img1.getWidth();
        int h1 = img1.getHeight();
        int w2 = img2.getWidth();
        int h2 = img2.getHeight();
        Graphics g = img2.getGraphics();//
        g.fillRect(0, 0, w2, h2);

        g.setColor(Color.black);
        Font mFont = new Font("微软雅黑", Font.PLAIN, 25);
        g.setFont(mFont);
        LocalDate today = LocalDate.now();

        String nowDate = today.getYear()+"年"+today.getMonthValue()+"月"+today.getDayOfMonth()+"日";

        String text = "我坐在窗边给你发了99条消息 你终于肯回我了你说“**发你妈啊**” 我一下子就哭了，原来努力真的有用 你已经开始考虑想见我的妈妈了 你其实也是挺喜欢我的。";
        int lineHeight = 80;
        g.drawString(nowDate,20,40);
        for (int i = 0 ;i < text.length();i+=15){
//            text.substring(i,)
            g.drawString(text,20,lineHeight);
            lineHeight +=40;
        }
//        g.drawString(text, 0, 0);
        FontMetrics fontMetrics = g.getFontMetrics(mFont);
        int textWidth = fontMetrics.stringWidth(text);



        // 从图片中读取RGB
        int[] ImageArrayOne = new int[w1 * h1];
        ImageArrayOne = img1.getRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 逐行扫描图像中各个像素的RGB到数组中
        int[] ImageArrayTwo = new int[w2 * h2];
        ImageArrayTwo = img2.getRGB(0, 0, w2, h2, ImageArrayTwo, 0, w2);

        // 生成新图片
        BufferedImage DestImage = null;
        if (isHorizontal) { // 水平方向合并
            DestImage = new BufferedImage(w1+w2, h1, BufferedImage.TYPE_INT_RGB);
            DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            DestImage.setRGB(w1, 0, w2, h2, ImageArrayTwo, 0, w2);
        } else { // 垂直方向合并
            DestImage = new BufferedImage(w1, h1 + h2, BufferedImage.TYPE_INT_RGB);
            DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB
            DestImage.setRGB(0, h1, w2, h2, ImageArrayTwo, 0, w2); // 设置下半部分的RGB
        }


        ImageIO.write(DestImage, "jpg", new File(outPath));
        return DestImage;
    }
    public static void main(String[] args) throws IOException {
//        ImageUtils.margeImage("E:\\Development\\BackEnd\\Java\\Gitee\\JavaLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\simp\\d2.jpg",
//                "E:\\Development\\BackEnd\\Java\\Gitee\\JavaLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\simp\\3.jpeg",
//                "E:\\Development\\BackEnd\\Java\\Gitee\\JavaLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\simp\\11.jpg");

                ImageUtils.mergeImage("E:\\Development\\BackEnd\\Java\\Gitee\\JavaLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\simp\\d2.jpg",
                "E:\\Development\\BackEnd\\Java\\Gitee\\JavaLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\simp\\wenzi.jpeg",
                "E:\\\\Development\\\\BackEnd\\\\Java\\\\Gitee\\\\JavaLearning\\\\springboot-reptile\\\\src\\\\main\\\\java\\\\com\\\\reptile\\\\simp\\\\11.jpg",false);
    }

}
