package com.maowei.learning.thread;

public class ThreadTest extends Thread{
    int i = 0;
    //重写run方法，run方法的方法体就是现场执行体
    public void run()
    {
        for(;i<10;i++){
            System.out.println(getName()+"  "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
    {
        new ThreadTest().start();
        new ThreadTest().start();
    }
}
