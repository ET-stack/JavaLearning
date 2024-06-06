package com.reptile;

/**
 * @className: c
 * @description: TODO 类描述
 * @author:
 * @date: 2023/7/12
 **/
import java.util.*;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class AZEncrypter {

    // 偏移量
    private int offset;

    // 构造函数，设置偏移量
    public AZEncrypter(int offset) {
        this.offset = offset;
    }


    // 加密函数
    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                // 根据偏移量替换字母
                char newChar = (char) ((c - 'a' + offset) % 26 + 'a');
                sb.append(newChar);
            } else if (c >= 'A' && c <= 'Z') {
                // 根据偏移量替换字母
                char newChar = (char) ((c - 'A' + offset) % 26 + 'A');
                sb.append(newChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 查找第n个质数
    public static int findNthPrime(int n) {
        int count = 0;
        int num = 2;
        while (count < n) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }
            num++;
        }
        return num - 1;
    }

    // 示例程序入口
    public static void main(String[] args) {
        String input = "hello, world!";
        int offset = findNthPrime(2);
        AZEncrypter encrypter = new AZEncrypter(offset);
        String encrypted = encrypter.encrypt(input);
        System.out.println(encrypted);



    }
}