package com.xiao.demo;/**
 * Created by 小飞 on 2019/8/2.
 *
 * @Auther: 小飞
 * @Date: 2019/8/2 22:08
 * @Description:
 */

/**
 * @Auther: 小飞
 * @Date: 2019/8/2 22:08
 * @Description:
 */

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.*;

public class FreemarkerTest {

    private static final String TEMPLATE_PATH = "src/main/resources/templates";
    //模板路径【指向你自己的模板文件存放路径】

    public static void main(String[] args) {

        autoGenJAVATest();//通过.ftl模板生成java类

    }

    /**
     * 根据模板自动创建java类-示例
     */
    private static void autoGenJAVATest() {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("classPath", "com.xiao.demo");
        dataMap.put("className", "AutoGenHello");
        dataMap.put("helloWorld", "通过<代码自动生成程序> 演示 FreeMarker的HelloWorld！");

        String DEST_PATH = "src\\main\\java\\com\\xiao\\demo";
        //目标路径【指向你自己的类文件存放路径】
        genFileWithTemplate(TEMPLATE_PATH, DEST_PATH, "hello.ftl", "AutoGenHello.java", dataMap);
    }

    /**
     * 通过.flt模板生成file(封装了一下 方便统一调用)
     * @param templateDir
     * @param destDir
     * @param templateFileName
     * @param destFileName
     * @param dataMap
     */
    private static void genFileWithTemplate(String templateDir, String destDir, String templateFileName, String destFileName, Map<String, Object> dataMap) {
        //创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            //设置模版路径
            configuration.setDirectoryForTemplateLoading(new File(templateDir));
            //加载模版文件
            Template template = configuration.getTemplate(templateFileName);
            //生成数据
            File docFile = new File(destDir + "\\" + destFileName);
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            //输出文件
            template.process(dataMap, out);
            System.out.println(destFileName + " 模板文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                    out.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
