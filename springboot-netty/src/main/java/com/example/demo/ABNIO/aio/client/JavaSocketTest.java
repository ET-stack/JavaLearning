package com.example.demo.ABNIO.aio.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @className: JavaSocketTest
 * @description: TODO 类描述
 * @date: 2023/7/28
 **/
public class JavaSocketTest {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) !=-1){
            String message = new String(bytes,0,len);
            System.out.println(message);
        }


    }
}
