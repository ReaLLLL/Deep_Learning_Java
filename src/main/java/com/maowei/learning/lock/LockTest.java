package com.maowei.learning.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;


public class LockTest {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Lock lock3 = new ReentrantLock();
    private Condition condition1 = lock1.newCondition();
    private Condition condition2 = lock2.newCondition();
    private Condition condition3 = lock3.newCondition();
    private volatile AtomicInteger countAC = new AtomicInteger(0);
    private volatile AtomicInteger countB = new AtomicInteger(0);

    public LockTest(){
    }

    public void A()
    {
        this.countAC.incrementAndGet();

        this.lock1.lock();

        try {
            while(this.countB.get() != 0)
                this.condition1.await();

            System.out.println("This is A method!");

            if(this.countB.get() != 0){
                this.lock2.lock();
                if(this.countB.get() != 0)
                    this.condition2.signalAll();
                this.lock2.unlock();

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            this.lock1.unlock();

            this.countAC.decrementAndGet();
        }
    }

    public void B(){

        if(this.countAC.get() !=0){
            this.lock2.lock();
            try {
                while (this.countAC.get()!=0){
                    this.condition2.await();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                this.lock2.unlock();
            }
        }

        this.countB.incrementAndGet();

        System.out.println("This is B method!");

        this.countB.decrementAndGet();

        if(this.countAC.get()!=0){
            this.lock1.lock();
            //this.lock3.lock();

            if(this.countAC.get()==0) {
                this.condition1.signalAll();
                //this.condition3.signal();
            }
            //this.lock3.unlock();
            this.lock1.unlock();
        }
    }

    /*public void C()
    {
        this.lock3.lock();

        this.countAC.incrementAndGet();

        try {
            while(this.countB.get() != 0)
                this.condition3.await();

            System.out.println("This is A method!");

            if(this.countB.get() != 0){
                this.lock2.lock();
                if(this.countB.get() != 0)
                    this.condition2.signal();
                this.lock2.unlock();

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {

            this.countAC.decrementAndGet();

            this.lock3.unlock();
        }
    }*/

    public static void main(String[] args){
        final LockTest t = new LockTest();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    t.A();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    t.B();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        /*Thread t3 = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    t.C();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });*/

        t1.start();
        t2.start();
        //t3.start();
    }
}
