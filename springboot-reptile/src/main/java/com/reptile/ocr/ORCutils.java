package com.reptile.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * @className: doOCRFromFile
 * @description: TODO 类描述
 *
 * @date: 2022/10/19
 **/
public class ORCutils {


        public static void main(String[] args) throws TesseractException {
            ITesseract instance = new Tesseract();
            // 指定训练数据集合的路径
            instance.setDatapath("C:\\Program Files (x86)\\Tesseract-OCR\\tessdata");

            // 指定识别图片
            File imgDir = new File("D:\\code\\ocr\\src\\main\\resources\\hello.png");
            long startTime = System.currentTimeMillis();
            String ocrResult = instance.doOCR(imgDir);

            // 输出识别结果
            System.out.println("OCR Result: \n" + ocrResult + "\n 耗时：" + (System.currentTimeMillis() - startTime) + "ms");
        }



}
