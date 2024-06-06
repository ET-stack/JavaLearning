package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className: BeanFormat
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/8/5
 **/
public class ObjectFormat {
     ObjectMapper mapper = new ObjectMapper();
     ObjectNode rootNode = mapper.createObjectNode();

     String resultStr= "";

    /**
     *
     * @param config
     *     key: property path
     *     value: string format
     */
    public ObjectFormat(Map<String,String> config){

        for (String key: config.keySet()){
            if (key.contains(".")){
                String a = key.substring(0,key.indexOf("."));
                String b = key.substring(key.indexOf(".")+1);
                ObjectNode node = mapper.createObjectNode();
                node.put(b,config.get(key));
                rootNode.put(a,node);
            }else {
                rootNode.put(key,config.get(key));
            }
        }

    }


    public String format(Object object) throws Exception {
        String resultJsonStr = rootNode.toString();
        if (object != null  ) {
           HashMap<String,String> valueAndFormatMap =  findStr(rootNode.toString());
            Class<?> clz = object.getClass();
            Field[] fields = clz.getDeclaredFields();



            for (Field field : fields) {
//                System.out.println(field.getGenericType());
                for (String key:valueAndFormatMap.keySet()){
                // 如果类型是String
                if (field.getGenericType().toString().equals(
                        "class java.lang.String") && field.getName().equals(key)) {
                    Method m = (Method) object.getClass().getMethod(
                            "get" + getMethodName(key));

                    String val = (String) m.invoke(object);
                    if (val != null) {
                        resultJsonStr = resultJsonStr.replaceAll("<"+key+">",val);
                        System.out.println("String type:" + val);
                    }

                }

                // 如果类型是Integer
                if (field.getGenericType().toString().equals(
                        "class java.lang.Integer")) {
                    Method m = (Method) object.getClass().getMethod(
                            "get" + getMethodName(field.getName()));
                    Integer val = (Integer) m.invoke(object);
                    if (val != null) {
                        System.out.println("Integer type:" + val);
                    }

                }

                // 如果类型是Double
                if (field.getGenericType().toString().equals(
                        "class java.lang.Double") && field.getName().equals(key)) {
                    Method m = (Method) object.getClass().getMethod(
                            "get" + getMethodName(field.getName()));
                    Double val = (Double) m.invoke(object);
                    DecimalFormat decimalFormat = new DecimalFormat(valueAndFormatMap.get(key));
                    if (val != null) {
                        String format = decimalFormat.format(val);
                        resultJsonStr = resultJsonStr.replaceAll("<"+key+":"+valueAndFormatMap.get(key)+">",format);
                        System.out.println("Double type:" + val);
                    }

                }

                // 如果类型是Boolean 是封装类
                if (field.getGenericType().toString().equals(
                        "class java.lang.Boolean")) {
                    Method m = (Method) object.getClass().getMethod(
                            field.getName());
                    Boolean val = (Boolean) m.invoke(object);
                    if (val != null) {
                        System.out.println("Boolean type:" + val);
                    }

                }

                // 反射找不到getter的具体名
                if (field.getGenericType().toString().equals("boolean")) {
                    Method m = (Method) object.getClass().getMethod(
                            field.getName());
                    Boolean val = (Boolean) m.invoke(object);
                    if (val != null) {
                        System.out.println("boolean type:" + val);
                    }

                }
                // 如果类型是Date
                if (field.getGenericType().toString().equals(
                        "class java.util.Date") && field.getName().equals(key)) {
                    Method m = (Method) object.getClass().getMethod(
                            "get" + getMethodName(field.getName()));
                    Date val = (Date) m.invoke(object);
                    if (val != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat(valueAndFormatMap.get(key));
                        resultJsonStr = resultJsonStr.replaceAll("<"+key+":"+valueAndFormatMap.get(key)+">",sdf.format(val));
                        System.out.println("Date type:" + val);
                    }

                }
                // 如果类型是Short
                if (field.getGenericType().toString().equals(
                        "class java.lang.Short")) {
                    Method m = (Method) object.getClass().getMethod(
                            "get" + getMethodName(field.getName()));
                    Short val = (Short) m.invoke(object);
                    if (val != null) {
                        System.out.println("Short type:" + val);
                    }

                }

            }
            }

        }
        System.out.println();
        return resultJsonStr;
    }
    private static String getMethodName(String fildeName){
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }
    static String formatToString(String pattern,Number number){
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(number);
       return format;
    }
    public  HashMap<String,String>  findStr(String rootStr){
        HashMap<String,String> resultMap = new HashMap<String,String>();
        String regex = "\\<([^>]*)\\>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rootStr);

        while (matcher.find()) {
            String reStr = rootStr.substring(matcher.start() + 1, matcher.end() - 1);
            if (reStr.contains(":")){
                resultMap.put(reStr.substring(0,reStr.indexOf(":")),reStr.substring(
                        reStr.indexOf(":")+1));
            }else {
                resultMap.put(reStr,"");
            }

        }

        return resultMap;
    }





    public static void main(String[] args) throws Exception {
//        Map<String,String>  config = new HashMap<>();
//        config.put("b.time","今天的日期是<a2:yyyy-MM-dd>");
//        config.put("dbl","数值<a1>为：<a3:###,##0.00>");
//        AA aa = new AA();
//        aa.setA1("a1");
//        aa.setA2(new Date());
//        aa.setA3(10.2);
//        ObjectFormat format = new ObjectFormat(config);
//        String objStr =  format.format(aa);
//        System.out.println("返回后的值"+objStr);
//        Object object = new AA();
//        Class <?>  clz = object.getClass();
//       Field [] fields = clz.getDeclaredFields();
//       for (Field field: fields){
//           System.out.println("字段类型为GetType方法"+field.getType().getName()+"GenericType方法为"+field.getGenericType());
//       }
        Class clz = Class.forName("com.example.demo.ObjectFormat");
        Method method = clz.getMethod("setPrice", Object.class);
        Constructor constructor = clz.getConstructor();
        Object object = constructor.newInstance();
        method.invoke(object, 4);
    }
}
