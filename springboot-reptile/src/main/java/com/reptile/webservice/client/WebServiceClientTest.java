package com.reptile.webservice.client;

/**
 * @className: WebServiceClientTest
 * @description: TODO 类描述
 * 
 * @date: 2022/10/20
 **/
public class WebServiceClientTest {
    public static void main(String[] args) {
        HelloServiceImplService service = new HelloServiceImplService();
        HelloServiceImpl helloService = service.getHelloServiceImplPort();
        People people = new People();
        people.setAge(12);
        people.setName("张三");
        helloService.sayHello(people);
    }

}
