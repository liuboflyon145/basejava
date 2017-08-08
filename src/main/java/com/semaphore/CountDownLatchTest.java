package com.semaphore;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liubo on 2016/10/31.
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        CountDownLatch latch = new CountDownLatch(2);
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread number "+Thread.currentThread().getId());
                }
            };
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            try {
                System.out.println("countDownLatch个数为："+latch.getCount());
                System.out.println("第"+(i+1)+"个线程执行中。。。。。。");
                latch.countDown();
                System.out.println("当前数为:"+latch.getCount());
                latch.countDown();
                latch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {

            }

        }
    }
}
