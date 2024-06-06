package com.xiao.demo;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 小飞
 */
public class GenMain {

    public static void main(String[] args) throws IOException {
        // 参数值
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("type", "String");
        map.put("name", "testName");

        // 模板目录
        String templateDirectory = "src\\main\\resources\\templates";
        // 模板名称
        String templateFile = "test.java";
        // 模板生成后存放目录
        String targetPath = "C:/test";
        // 模板生成后新文件名
        String fileName = "ntest.java";
        // 创建文件夹
        new File(targetPath).mkdirs();
        File nFile = new File(targetPath + "/" + fileName);
        if (nFile.exists()) {
            throw new RuntimeException("File \'" + fileName + "\' already exists");
        }

        // 生成目标文件
        Writer writer = null;
        try {
            writer = new FileWriter(nFile);

            Template template = getConfiguration(templateDirectory).getTemplate(templateFile, "UTF-8");

            template.process(map, writer);

        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }
    }

    private static Configuration getConfiguration(String templateDirectory) {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
        try {
            configuration.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
            configuration.setDirectoryForTemplateLoading(new File(templateDirectory));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return configuration;
    }
}
