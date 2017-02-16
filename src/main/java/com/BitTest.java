package com;

/**
 * Created by liubo16 on 2016/11/24.
 */
public class BitTest {
    private static final int MAXIMUM_CAPACITY = 100000;
    public static void main(String[] args) {
        bitMove();
        //System.out.println(tableSizeFor(3));
    }
    private static void bitMove(){
        int number = 10;
        prn(number);
        number |= number <<=2;
        prn(number);
        number >>=1;
        prn(number);
        number >>>=1;
        prn(number);
    }

    private static void prn(int number) {
        System.out.println("this number is :"+number);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
