package com.threadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liubo16 on 2017/8/10.
 */
public class ThreadLocalTest {

    int commonNum = 10;

    public static void main(String[] args) {
//        ThreadLocal threadLocal = new ThreadLocal();
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.threadCall();
    }

    private void threadCall(){
        List<Thread> threadList = new ArrayList();

        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" " +Thread.currentThread().getId()+" CommonNum = "+commonNum);
                    commonNum+=1;
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            });
            System.out.println("新建线程name："+thread.getName()+" id: "+thread.getId());
            threadList.add(thread);
        }

        threadList.stream().forEach(o -> {
            o.start();
        });
    }
}
