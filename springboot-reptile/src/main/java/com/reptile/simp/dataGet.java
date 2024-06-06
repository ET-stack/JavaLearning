package com.reptile.simp;

import com.reptile.utils.HttpURLConnectionUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: dataGet
 * @description: TODO 类描述
 * @author:
 * @date: 2022/11/8
 **/
public class dataGet {

    public static void main(String[] args) {
        Map<String,Object> dataMap = new HashMap();
        String filePath = "E:\\Development\\BackEnd\\Java\\Gitee\\JavaLearning\\springboot-reptile\\src\\main\\java\\com\\reptile\\simp\\test.txt";
      for (int i = 0;i <400;i++){
//          String data = HttpURLConnectionUtil.doGet("https://api.ixiaowai.cn/tgrj/index.php");
//          String data = HttpURLConnectionUtil.doGet("https://api.oick.cn/dog/api.php");
          String data = HttpURLConnectionUtil.doGet("https://cloud.qqshabi.cn/api/tiangou/api.php");
          try {
              Thread.sleep(3000);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          if (!dataMap.containsKey(data)){
              dataMap.put(data,"");
          }
      }


        try{
            File file = new File(filePath);
            FileOutputStream fos = null;
            if(!file.exists()){
                file.createNewFile();//如果文件不存在，就创建该文件
                fos = new FileOutputStream(file);//首次写入获取
            }else{
                //如果文件已存在，那么就在文件末尾追加写入
                fos = new FileOutputStream(file,true);//这里构造方法多了一个参数true,表示在文件末尾追加写入
            }

            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//指定以UTF-8格式写入文件
                //遍历Map
                for(Map.Entry<String, Object> entry : dataMap.entrySet()){
                    //以英文","逗号隔开多个写入的str，每个Map写一行
                    String str = entry.getKey()+"="+entry.getValue();
                    osw.write(str+",");
                    osw.write("\r\n");
                }

                //每写入一个Map就换一行


            //写入完成关闭流
            osw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
