package com.maowei.learning.thread;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: ThreadA.java, v 0.1 2018年01月04日 下午11:41:41 alexsong Exp $
 */
public class ThreadA implements Runnable {
    private Object object;

    public ThreadA(Object object){
        this.object = object;
    }

    public void run() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"  Start");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  End");
        }
    }
}
