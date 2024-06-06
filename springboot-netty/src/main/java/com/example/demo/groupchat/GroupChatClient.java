package com.example.demo.groupchat;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author Yi
 * @date 2020/7/27 22:53
 */
public class GroupChatClient {
    //定义相关的属性
    private final String HOST = "127.0.0.1";
    private final int PORT = 6667;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    public GroupChatClient() throws IOException {
        Selector open = Selector.open();
    }

    public static void main(String[] args) {


    }
}
