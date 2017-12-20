package com.maowei.learning.proxy;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: RealSubject.java, v 0.1 2017年12月20日 上午10:24:24 alexsong Exp $
 */
public class RealSubject implements Subject {
    public void doSomething() {
        System.out.println("这是真正的对象");
    }
}
