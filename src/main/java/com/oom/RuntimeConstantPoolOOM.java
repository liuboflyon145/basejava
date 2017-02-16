package com.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liubo16 on 2017/2/7.
 */
public class RuntimeConstantPoolOOM {
    //运行时常量池导致内存溢出异常
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++));
            System.out.println("run times "+list.get(i-1).intern());
        }
    }
}
