package com.forkjoin;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinTaskDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool fjp = new ForkJoinPool();
        DemoTask task =  new DemoTask();
        ForkJoinTask<String> fjt = ForkJoinTask.adapt(task);
        String str = fjp.invoke(fjt);
        System.out.println(fjt.isDone());
        System.out.println("=====result======"+str);
    }

    static class DemoTask implements Callable<String> {
        public String call() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            return "Task Done";
        }
    }
}

 