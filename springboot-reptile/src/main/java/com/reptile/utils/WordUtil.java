package com.reptile.utils;

/**
 * @className: WordUtil
 * @description: TODO 类描述
 * @author:
 * @date: 2022/10/12
 **/

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.reptile.mingyantong.mingyantongJSOUPMain;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import sun.misc.BASE64Encoder;

public class WordUtil {

    private Configuration configuration = null;

    /****
     * 模板文件存放的目录
     */
    private static final String  baseDir = "E:\\Development\\BackEnd\\Java\\Gitee\\SpringBootLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\utils";
    /***
     * 模板文件名称
     */
    private static final String  templateFile = "模板.ftl";
    /***
     * word生成的输出目录
     */
    private static final String  outputDir = "E:\\Development\\BackEnd\\Java\\Gitee\\SpringBootLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\utils";

    public WordUtil(){
        configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
    }

    public static void main(String[] args) {
        WordUtil test = new WordUtil();
        Map<String,String> testMap=new HashMap<String,String>();
        List<String> dataList = new ArrayList<>();
        mingyantongJSOUPMain.getData(dataList);
        int count = 1;
        int fileCount = 0;
//        for (int i =0;i < dataList.size();i++){
           testMap.put("test"+count,dataList.get(0));
            testMap.put("img1", ImageToBase64ByLocal("E:\\Development\\BackEnd\\Java\\Gitee\\SpringBootLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\img\\page_6no_1732084.png"));
            count++;
           if (count == 21){
               test.createWord(testMap,fileCount);
               fileCount++;
               testMap = new HashMap<>();
               count = 1;
           }
//        }

    }



    /**
     * 本地图片转换成base64字符串
     * @param imgFile	图片本地路径
     * @return
     *
     * @author
     * @dateTime
     */
    public static String ImageToBase64ByLocal(String imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理


        InputStream in = null;
        byte[] data = null;

        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);

            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }


    public String image2byte(String path) throws IOException {
        byte[] data = null;
        URL url = null;
        InputStream input = null;
        try{
            url = new URL(path);
            HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            httpUrl.getInputStream();
            input = httpUrl.getInputStream();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int numBytesRead = 0;
        while ((numBytesRead = input.read(buf)) != -1) {
            output.write(buf, 0, numBytesRead);
        }
        data = output.toByteArray();
        output.close();
        input.close();
        BASE64Encoder encoder = new BASE64Encoder();

        return encoder.encode(data);
    }

    /*****
     *
     * Project Name: maventest
     * <p>转换成word<br>
     *
     * @author youqiang.xiong
     * @date 2019年2月21日  上午11:22:03
     * @version v1.0
     * @since
     */
    public void createWord(Map<String,String> dataMap,Integer fileCount){
//        Map<String,Object> dataMap=new HashMap<String,Object>();

        //构造参数
//        getData(dataMap);

        configuration.setClassForTemplateLoading(this.getClass(), "");//模板文件所在路径
        Template t=null;
        try {
            configuration.setDirectoryForTemplateLoading(new File(baseDir));
            t = configuration.getTemplate(templateFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File outFile = new File(outputDir+fileCount+".doc"); //导出文件
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            t.process(dataMap, out); //将填充数据填入模板文件并输出到目标文件
            System.out.println("生成成功...");
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /****
     *
     * Project Name: maventest
     * <p>初始化数据map <br>
     *
     * @author youqiang.xiong
     * @date 2019年2月21日  上午11:26:34
     * @version v1.0
     * @since
     * @param dataMap
     * 		封装数据的map
     */
    private void getData(Map<String, Object> dataMap) {
        dataMap.put("userName", "刘德华");
        dataMap.put("sex", "男");
        dataMap.put("nation", "汉族");
        dataMap.put("birthday", "1985-02-26");
        dataMap.put("nationPlace", "春日部");
        dataMap.put("politicalStatus", "党员");
        dataMap.put("graduationSchool", "双叶幼稚园");
        dataMap.put("lastBackground", "幼稚园");
        dataMap.put("graduationMajor", "玩泥沙");
        dataMap.put("workUnit", "NASA");
        dataMap.put("business", "煮菜的");
        dataMap.put("postalAddress", "lc");
        dataMap.put("postalcode", "lc");
        dataMap.put("mobile", "18898416969");
        dataMap.put("admissionTicket", "lc");
        dataMap.put("enterSchoolTime", "lc");
        dataMap.put("emergencyContact", "lc");
        dataMap.put("readingInstrouction", "lc");
        dataMap.put("year", "2019");
        dataMap.put("month", "02");
        dataMap.put("day", "20");

    }
}

