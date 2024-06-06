/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.demo;

import com.google.common.base.Throwables;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptUtil {

    private static final String AES = "AES";

    private static final String AES_GENARATE_WORD = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final Integer AES_LENGTH = 32;

    /**
     * demo
     *
     * @param args
     */
    public static void main(String[] args) {
        String content = "data";
        String password = "123456";
        byte[] key = EncryptUtil.getAESKeyByPassword(password).getBytes();
        String encryptContent = EncryptUtil.encrypt(content, key);
        System.out.println("encryptContent is: " + encryptContent);
    }

    /**
     * 获取对称加密的密钥
     *
     * @param password
     * @return
     */
    public static String getAESKeyByPassword(String password) {
        if (password.length() < AES_LENGTH) {
            password += AES_GENARATE_WORD.substring(0, AES_LENGTH - password.length());
        }

        return password;
    }

    /**
     * 加密（密钥：type[]）
     *
     * @param data
     * @param key
     * @return
     */
    public static String encrypt(String data, byte[] key) {
        try {
            SecretKey secretKey = new SecretKeySpec(key, AES);
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            System.out.println("EncryptUtil encrypt error, data is:" + data + ", key is: " + key + ", cause by:" + Throwables.getStackTraceAsString(e));
            return null;
        }
    }


    /**
     * 解密 (密钥：type[])
     *
     * @param data
     * @param key
     * @return
     */
    public static String decrypt(String data, byte[] key) {
        try {
            SecretKey secretKey = new SecretKeySpec(key, AES);

            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data)), "UTF-8");
        } catch (Exception e) {
            System.out.println("EncryptUtil decrypt error, data is:" + data + ", key is: " + key + ", cause by:" + Throwables.getStackTraceAsString(e));
            return null;
        }
    }
}