package com.dubbo.impl;


import com.dubbo.interfaces.DemoService;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "Hello " + name;
    }

}