package com.watcher.test;

/**
 * Created by liubo on 2016/10/25.
 */
public interface InterfaceTest {
    public  void open();
}

class IntTest implements InterfaceTest{
    @Override
    public void open() {
        System.out.println("=============");
    }
}