package test;

/**
 * @className: socketTest
 * @description: TODO 类描述
 * @author:
 * @date: 2023/8/4
 **/
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SocketSender {
    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int sum = 0;
        HashMap<Character, Integer> map = new LinkedHashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        boolean hasOddCount = false;
        for (Character sc : map.keySet()) {
            if (map.get(sc) % 2 == 1) {
                sum += map.get(sc) - 1;
                hasOddCount = true;

            } else {
                sum += map.get(sc);

            }
        }

        // 如果存在奇数次字符，可以将其中一个字符放在回文串的中间
        if (hasOddCount) {
           return sum+1;
        }

        return sum;

    }
    public static void main(String[] args) throws IOException {
        System.out.println(  new SocketSender().longestPalindrome("tattarrattat"));
    }
}