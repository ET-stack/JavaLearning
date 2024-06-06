package com.reptile.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface HelloServiceInterface {

    @WebMethod
    public String sayHello(People people);
}