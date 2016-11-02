package com.sync;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liubo on 2016/11/2.
 */
public class Worker implements Runnable {
    private final CountDownLatch start ;
//    private final CountDownLatch done;

    public Worker(CountDownLatch start) {
        this.start = start;
//        this.done = done;
    }

    @Override
    public void run() {
        try {
//            start.wait();
            doWork();
//            done.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doWork() {
        System.out.println("开始工作。。。。。。");
    }
}
