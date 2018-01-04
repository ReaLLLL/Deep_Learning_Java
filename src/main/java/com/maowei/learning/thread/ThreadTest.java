package com.maowei.learning.thread;

public class ThreadTest{
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Runnable t1 = new ThreadA(o);
        new Thread(t1).start();
        Thread.sleep(5000);
        Runnable t2 = new ThreadB(o);
        new Thread(t2).start();
    }
}
