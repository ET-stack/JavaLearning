package com.reptile.webservice;

import javax.xml.ws.Endpoint;


public class StartService {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/WebService81/Newcapec.eCard.ProxyWebService.asmx", new HelloServiceImpl());
        System.out.println("publish success...");
    }

}
