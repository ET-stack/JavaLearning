package com.reptile.simp;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.sun.imageio.plugins.common.ImageUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;

/**
 * <p>Title: PictureMerge</p>
 * <p>Description: 图片合并</p>
 * <p>Company: DINGGE</p>
 * @author    FANQIBU
 * @date       2017年12月1日
 */
public class PictureMerge {

    public static void main(String[] args) {
        try {
// 读取第一张图片
// File fileOne = new File("D:qq.jpg");
// BufferedImage ImageOne = ImageIO.read(fileOne);
// int width = ImageOne.getWidth();//图片宽度
// int height = ImageOne.getHeight();//图片高度

// 对第二张图片做相同的处理
            File fileTwo = new File("E:\\Development\\BackEnd\\Java\\Gitee\\JavaLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\simp\\d1.jpg");
            BufferedImage ImageTwo = ImageIO.read(fileTwo);

            int width = ImageTwo.getWidth();// 图片宽度
            int height = ImageTwo.getHeight();// 图片高度
            int height2 = 20;

            BufferedImage ImageOne = new BufferedImage(width, height2,
                    BufferedImage.TYPE_4BYTE_ABGR);
// ImageOne.get

            Graphics g = ImageOne.getGraphics();//
            g.fillRect(0, 0, width, height);
            g.setColor(Color.blue);
            Font mFont = new Font("宋体", Font.PLAIN, 12);
            g.setFont(mFont);
            String text = "我坐在窗边给你发了99条消息，你终于肯回我了你说“**发你妈啊**”，我一下子就哭了，原来努力真的有用，你已经开始考虑想见我的妈妈了，你其实也是挺喜欢我的。";
            g.drawString(text, 100, 1000);
// 从图片中读取RGB
            int[] ImageArrayOne = new int[width * height2];
            ImageArrayOne = ImageOne.getRGB(0, 0, width, height2,
                    ImageArrayOne, 0, width);

            int[] ImageArrayTwo = new int[width * height];
            ImageArrayTwo = ImageTwo.getRGB(0, 0, width, height, ImageArrayTwo,
                    0, width);

// 生成新图片
            BufferedImage ImageNew = new BufferedImage(width, height + height2,
                    BufferedImage.TYPE_INT_RGB);
            ImageNew.setRGB(0, 0, width, height2, ImageArrayOne, 0, width);// 设置上半部分的RGB
// ImageNew.setRGB(width,0,width,height,ImageArrayTwo,0,width);//设置右半部分的RGB
            ImageNew.setRGB(0, height2, width, height, ImageArrayTwo, 0, width);// 设置下半部分的RGB

            File outFile = new File("E:\\Development\\BackEnd\\Java\\Gitee\\JavaLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\simp\\d2.jpg");
            ImageIO.write(ImageNew, "jpg", outFile);// 写图片
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
