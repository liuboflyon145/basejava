package com.oom;

/**
 * Created by liubo16 on 2017/2/7.
 */
public class StackOutOfMemoryTest {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackOutOfMemoryTest soo = new StackOutOfMemoryTest();
        soo.stackLeak();
    }
}

/**
 **
 Exception in thread "main" java.lang.StackOverflowError
 at com.oom.StackOutOfMemoryTest.stackLeak(StackOutOfMemoryTest.java:10)
 at com.oom.StackOutOfMemoryTest.stackLeak(StackOutOfMemoryTest.java:11)
 at com.oom.StackOutOfMemoryTest.stackLeak(StackOutOfMemoryTest.java:11)
 at com.oom.StackOutOfMemoryTest.stackLeak(StackOutOfMemoryTest.java:11)
 at com.oom.StackOutOfMemoryTest.stackLeak(StackOutOfMemoryTest.java:11)
 at com.oom.StackOutOfMemoryTest.stackLeak(StackOutOfMemoryTest.java:11)
 at com.oom.StackOutOfMemoryTest.stackLeak(StackOutOfMemoryTest.java:11)
 at com.oom.StackOutOfMemoryTest.stackLeak(StackOutOfMemoryTest.java:11)
 */