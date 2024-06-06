package com.example.demo.demo;

/**
 * @author Yi
 * @date 2020/7/29 11:42
 */
public class HttpSnoopServer {
    static final boolean SSL = System.getProperty("ssl") != null;
    static final int PORT = Integer.parseInt(System.getProperty("port", SSL ? "8443" : "8080"));
}
