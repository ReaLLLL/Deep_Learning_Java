package com.maowei.learning.lock;

import java.util.concurrent.locks.Lock;

public class LockTest {
    public static void main(String[] args){
        Lock lock = new MyLock();
        for(int i = 0; i < 10; i++){
            TestThread t = new TestThread(lock);
            //t.setDaemon(true);
            t.start();
        }
    }
}
