package com.example.demo;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className: test
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/8/5
 **/
public class test {


    public static void main(String[] args) {
//        System.out.println( "12341".replaceAll("12","3"));

        String s = "123456{0}";
        String inputStr = "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";
        int first = 0;
        int last = 0;
        int count = 0;
//        boolean result = s.indexOf('{') > 0;
//        if (result) {
//            StringBuilder sb = new StringBuilder();
//            sb =
//            do {
//
//                result = s.indexOf('{') > 0;
//            } while (result);
//        }

        char[] sArr = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        String regex = "\\{([^}]*)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        String resultStr= "";
        while (matcher.find()) {
            String reStr = s.substring(matcher.start() + 1, matcher.end() - 1);
            String targetStr = regex(reStr,inputStr);
            resultStr = s.replaceAll("\\{"+reStr+"}",targetStr);

        }
        System.out.println(resultStr);
    }

    /**
     * param fromStr: 123456{0}
     * @param reStr a,a,a.b
     * @param reJSONStr  JSON字符串 {"0":"zhangsan","1":"lisi","2":"wangwu","3":"maliu"}
     * @return
     */
    private static String regex(String reStr,String  reJSONStr) {
        Map map = new HashMap();
        if (reStr.length() == 1)
        return (String) map.get(reStr);
        return "";
    }
}
