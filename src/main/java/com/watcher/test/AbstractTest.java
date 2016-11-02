package com.watcher.test;

/**
 * Created by liubo on 2016/10/25.
 */
public abstract class AbstractTest {
    public abstract void open();
}

class A extends AbstractTest{

    @Override
    public void open() {
        System.out.println("抽象类的子类");
    }
}