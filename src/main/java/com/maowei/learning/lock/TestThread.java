package com.maowei.learning.lock;

import org.aspectj.weaver.ast.Test;

import java.util.concurrent.locks.Lock;

public class TestThread extends Thread {
    private Lock lock;
    public TestThread(Lock lock){
        this.lock = lock;
    }

    public void run(){
        while (true){
            lock.lock();
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
