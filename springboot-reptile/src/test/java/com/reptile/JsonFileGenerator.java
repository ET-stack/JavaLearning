package com.reptile;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @className: jsonFile
 * @description: TODO 类描述
 * @author:
 * @date: 2023/9/5
 **/



import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class JsonFileGenerator {
    public static void main(String[] args) {
        // 读取原始文件
        String inputFilePath = "E:\\Development\\Company\\fy\\NewGit\\vlib\\release\\GZU\\0010011\\floor_map_json"; // 替换为实际的JSON文件路径
        String outputFilePath = "E:\\Development\\Company\\fy\\NewGit\\vlib\\release\\GZU\\0010011\\floor_map_json_new"; // 替换为实际的输出文件路径

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
            int displayPriority = -1;
            String line;
            while ((line = reader.readLine()) != null) {

                // 解析原始数据
                JSONObject jsonObject = new JSONObject(line);

                // 修改JSON数据
                Map<String, Object> newJsonObject = new LinkedHashMap<>();
                newJsonObject.put("x",  jsonObject.getString("x") );
                newJsonObject.put("y",  jsonObject.getString("y") );
                newJsonObject.put("width",   jsonObject.getString("width") );
                newJsonObject.put("height",   jsonObject.getString("height") );
                newJsonObject.put("floor",   jsonObject.getString("floor") );
                newJsonObject.put("tips",   jsonObject.getString("tips") );
                newJsonObject.put("color",   jsonObject.getString("color") );

                // 逐条增加display_priority


                // 将display_name和display_in_building添加到JSON对象的末尾
                newJsonObject.put("display_name",   jsonObject.getString("tips"));
                newJsonObject.put("display_in_building", false);

                newJsonObject.put("display_priority",   displayPriority );
                displayPriority++;
//                 displayPriority = newJsonObject.getInt("display_priority");

                // 构造修改后的JSON字符串
                StringBuilder jsonBuilder = new StringBuilder();
                Iterator<Map.Entry<String, Object>> iterator = newJsonObject.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = iterator.next();
                    String key = entry.getKey();
                    Object value = entry.getValue();
                   if (!key.equals("display_priority") || key.equals("display_in_building")){
                       jsonBuilder.append("\"").append(key).append("\":\"").append(value).append("\"");
                   }else {
                       jsonBuilder.append(key).append(":").append(value);
                   }
                    if (iterator.hasNext()) {
                        jsonBuilder.append(", ");
                    }
                }

                // 写入修改后的JSON数据到新文件
                writer.write("{ " + jsonBuilder+ " }");
                writer.newLine();
            }
            // 关闭读写流
            reader.close();
            writer.close();
                // 写入修改后的JSON数据到新文件
//                writer.write(newJsonObject.toString());
//                writer.newLine();
            } catch (FileNotFoundException ex) {
        // 关闭读写流


            System.out.println("新文件已生成：" + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }


}