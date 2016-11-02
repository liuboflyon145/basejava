package com.hash;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by liubo on 2016/10/31.
 */
public class HashTest {
    public static void main(String[] args) {
        int k1 = 10;
        float k2 = 1;
        char k3 = 'a';
        double k4 = 4.0;
        long k5 = 2;
        Map map = new HashMap();
        map.put(k1,"1");
        map.put(k2,"2");
        map.put(k3,"3");
        map.put(k4,"4");
        map.put(k5,"5");

        Hashtable hashtable = new Hashtable();
        hashtable.put(k1,"1");
        hashtable.put(k2,"2");
        hashtable.put(k3,"3");
        hashtable.put(k4,"4");
        hashtable.put(k5,"5");
        System.out.println("map : "+map);
        System.out.println("hashtable :"+hashtable);
    }
}
