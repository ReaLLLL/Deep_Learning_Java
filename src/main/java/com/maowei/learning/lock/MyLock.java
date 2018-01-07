package com.maowei.learning.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLock implements Lock {
    private static final class Sync extends AbstractQueuedSynchronizer{
        Sync(int count){
            if(count <= 0)
                throw new IllegalArgumentException("Count must larger than zero");

            setState(count);
        }

        public int tryAcquireShared(int reduceCount){
            for(;;){
                int current = getState();
                int newCount = current - reduceCount;
                if(newCount < 0 || compareAndSetState(current, newCount))
                    return newCount;
            }
        }

        public boolean tryReleasedShared(int returnCount){
            for(;;){
                int current = getState();
                int newCount = current + returnCount;
                if(compareAndSetState(current, newCount))
                    return true;
            }
        }
    }

    private final Sync sync = new Sync(2);

    public void lock() {
        this.sync.tryAcquireShared(1);
    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public void unlock() {
        this.sync.tryReleasedShared(1);
    }

    public Condition newCondition() {
        return null;
    }
}
