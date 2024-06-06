package com.reptile;

import java.io.IOException;
import java.util.HashMap;

/**
 * @className: MapEqual
 * @description: TODO 类描述
 * @author:
 * @date: 2022/12/6
 **/
public class MapEqual {
    public static void main(String[] args) throws IOException, InterruptedException {

//        HashMap hm1 = new HashMap();
//        hm1.put("Shirts", new Integer(700));
//        hm1.put("Trousers", new Integer(600));
//        hm1.put("Jeans", new Integer(1200));
//        hm1.put("Android TV-------", new Integer(450));
//        hm1.put("空气净化器", new Integer(300));
//        hm1.put("食品加工机", new Integer(950));
//        HashMap hm2 = new HashMap();
//        hm2.put("Shirts", new Integer(700));
//        hm2.put("Trousers", new Integer(600));
//        hm2.put("Jeans", new Integer(1200));
//        hm2.put("Android TV-------", new Integer(450));
//        hm2.put("空气净化器", new Integer(300));
//        hm2.put("食品加工机", new Integer(951));
//        System.out.println(hm1.equals(hm2));
//        System.out.println((int) ((Math. random () * 9 + 1) * 100000));
        char[] s = {'1','2','3'};
        System.out.println(s);
        Process process = Runtime.getRuntime().exec("cmd /c devmgmt.msc");
        process.waitFor();
        System.out.println(process.exitValue());
    }
}
