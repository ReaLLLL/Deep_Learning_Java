package com.maowei.learning.thread;

public class RunnableTest implements Runnable {
    private int i;
    public void run()
    {
        for(;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"  "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
    {
        Runnable r = new RunnableTest();
        new Thread(r).start();
        new Thread(r).start();
    }
}
