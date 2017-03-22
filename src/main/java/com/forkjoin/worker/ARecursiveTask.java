package com.forkjoin.worker;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class ARecursiveTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID = -4702976772011326493L;

    private int[] intArray;

    private int start, end;

    public ARecursiveTask(int[] array, int start, int end) {
        this.intArray = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        Integer ret;
        WorkerThread thread = (WorkerThread) Thread.currentThread();

        thread.addTask();

        if (end - start > 100) {
            int mid = (start + end) / 2;
            ARecursiveTask task1 = new ARecursiveTask(intArray, start, mid);
            ARecursiveTask task2 = new ARecursiveTask(intArray, mid, end);

            invokeAll(task1, task2);
            ret = addResults(task1, task2);
        } else {
            int add = 0;

            for (int i = start; i < end; i++) {
                add += intArray[i];
            }

            ret = new Integer(add);
        }

        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ret;
    }

    private Integer addResults(ARecursiveTask task1, ARecursiveTask task2) {
        int value;

        try {
            value = task1.get().intValue() + task2.get().intValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
            value = 0;
        } catch (ExecutionException e) {
            e.printStackTrace();
            value = 0;
        }

        return new Integer(value);
    }
}