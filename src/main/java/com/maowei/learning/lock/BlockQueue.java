package com.maowei.learning.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class BlockQueue<T> {
    private int capacity;
    private List<T> list;
    private Lock lock;
    private Condition notEmpty;
    private Condition notFull;

    public BlockQueue(int capacity, Lock lock){
        this.capacity = capacity;
        this.list = new ArrayList<T>(capacity);
        this.lock = lock;
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public void add(T t) throws InterruptedException{
        this.lock.lock();
        try {
            while (this.list.size() == this.capacity)
                this.notFull.await();

            this.list.add(t);
            notEmpty.signal();
        }finally {
            this.lock.unlock();
        }
    }

    public void remove(T t) throws InterruptedException{
        this.lock.lock();
        try {
            while (this.list.size() == 0)
                this.notEmpty.await();

            this.list.remove(0);
            notFull.signal();
        }finally {
            this.lock.unlock();
        }
    }
}
