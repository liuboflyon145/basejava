package com.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liubo16 on 2017/2/22.
 */
public class CacheHealthChecker extends BaseHealthChecker {
    public CacheHealthChecker(CountDownLatch latch) {
        super("cache work ", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking "+this.getServiceName());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName()+" is Running");
    }
}
