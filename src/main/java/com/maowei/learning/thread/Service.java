package com.maowei.learning.thread;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: Service.java, v 0.1 2018年01月04日 下午10:44:44 alexsong Exp $
 */
public class Service {
    private int _num;

    public Service() {
    }

    public Service(int _num){
        this._num = _num;
    }

    public synchronized void count_2(){
        for(int i = 0; i < this._num; i++){
            System.out.println(Thread.currentThread().getName()+"  "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void count(){
        for(int i = 0; i < this._num; i++){
            synchronized (this) {
                try {
                    System.out.println(Thread.currentThread().getName()+"  "+ i);
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"  "+ i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void count(Integer num){
        for(int i = 0; i < num; i++){
            synchronized (num) {
                try {
                    System.out.println(Thread.currentThread().getName()+"  "+ i);
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName()+"  "+ i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized static void print(){
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
