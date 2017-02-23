package com.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by liubo16 on 2017/2/22.
 */
public class NetworkHealthChecker extends BaseHealthChecker {

    public NetworkHealthChecker(CountDownLatch latch) {
        super("Network Service", latch);
    }

    @Override
    public void verifyService() {

        System.out.println("checking "+this.getServiceName());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName()+" is Running");
    }
}
