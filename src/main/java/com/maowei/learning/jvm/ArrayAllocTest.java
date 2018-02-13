package com.maowei.learning.jvm;

public class ArrayAllocTest {

    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        System.out.println("First Allocation");
        byte[] allocation1 = new byte[_1MB];
        byte[] allocation2 = new byte[2*_1MB];
        byte[] allocation3 = new byte[3*_1MB];
        //byte[] allocation4 = new byte[4*_1MB];
       // byte[] allocation5 = new byte[5*_1MB];

//        System.out.println("Second Allocation");
//        byte[] allocation6 = new byte[12*_1MB];
    }
}
