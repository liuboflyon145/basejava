package com.forkjoin;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by liubo16 on 2017/2/16.
 */
public class SortTaskTest {
    private static final int NARRAY = 16; //For demo only
    long[] array = new long[NARRAY];
    Random rand = new Random();

    @Before
    public void setUp() {
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextLong() % 100; //For demo only
        }
        System.out.println("Initial Array: " + Arrays.toString(array));
    }

    boolean checkSorted(long[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > (a[i + 1])) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testSort() throws Exception {
//        long[] array = new long[]{5, 2, 12, 91, 34, -2, 8, 5, 4, 17, 9, 36};
        ForkJoinTask sort = new SortTask(array);
        ForkJoinPool fjpool = new ForkJoinPool();
        fjpool.submit(sort);
        fjpool.shutdown();

        fjpool.awaitTermination(30, TimeUnit.SECONDS);
        assertTrue(checkSorted(array));

    }
}