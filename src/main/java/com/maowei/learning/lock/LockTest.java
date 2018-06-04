package com.maowei.learning.lock;

import java.util.concurrent.locks.*;

public class LockTest {
    private  final Lock lock1;
    private  final ReadWriteLock lock2;
    private  final Lock lock3;

    public LockTest(){
        this.lock1 = new ReentrantLock();
        this.lock2 = new ReentrantReadWriteLock();
        this.lock3 = new ReentrantLock();
    }

    public static void main(String[] args){
        Lock lock = new MyLock();
        for(int i = 0; i < 10; i++){
            TestThread t = new TestThread(lock);
            //t.setDaemon(true);
            t.start();
        }
    }

    public void A()
    {
        this.lock1.lock();

        this.lock2.writeLock().lock();

        System.out.print("This is A method!");

        this.lock2.writeLock().unlock();

        this.lock1.unlock();
    }

    public void B(){
        this.lock2.readLock().lock();

        System.out.print("This is B method!");

        this.lock2.readLock().unlock();
    }

    public void C()
    {
        this.lock3.lock();

        this.lock2.writeLock().lock();

        System.out.print("This is C method!");

        this.lock2.writeLock().unlock();

        this.lock3.unlock();
    }
}
