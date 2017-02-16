package com.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liubo16 on 2017/2/7.
 */
public class OomTest {
    public static void main(String[] args) {
        List<Object> list = new ArrayList();
        while (true) {
            list.add(new Object());
            System.out.println("创建对象完成");
        }
    }
}
//
//创建对象完成
//        java.lang.OutOfMemoryError: Java heap space
//        Dumping heap to java_pid383996.hprof ...
//        Heap dump file created [12661600 bytes in 0.112 secs]
//        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//        at java.util.Arrays.copyOf(Arrays.java:3210)
//        at java.util.Arrays.copyOf(Arrays.java:3181)
//        at java.util.ArrayList.grow(ArrayList.java:261)
//        at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
//        at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
//        at java.util.ArrayList.add(ArrayList.java:458)
//        at com.oom.OomTest.main(OomTest.java:13)
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//        at java.lang.reflect.Method.invoke(Method.java:498)
//        at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)