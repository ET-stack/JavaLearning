package com.thread.demo.JUC.random;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            //输出10个在0-5之间（包括0，不包括5左开右闭区间的随机数）
            System.out.println(random.nextInt(5));
        }
    }
}
