package com.sync;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liubo on 2016/11/2.
 */
public class Driver {
    private static final int CAR_NUM = 5;
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch start = new CountDownLatch(5);
//        CountDownLatch done = new CountDownLatch(CAR_NUM);
        for (int i = 0; i < 9; i++) {
            System.out.println("order i = "+i);
            new Thread(new Worker(start)).start();
            System.out.println("线程"+Thread.currentThread().getId()+"启动完成");
            start.countDown();
            System.out.println("等待所有任务执行完成");
        }
        System.out.println(start.getCount());
        start.await();
    }
}
