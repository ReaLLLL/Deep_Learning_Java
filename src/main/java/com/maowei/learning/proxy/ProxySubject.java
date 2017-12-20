package com.maowei.learning.proxy;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: ProxySubject.java, v 0.1 2017年12月20日 上午10:25:25 alexsong Exp $
 */
public class ProxySubject implements Subject {

    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    public void doSomething() {
        System.out.println("这是一个代理对象");

        this.subject.doSomething();
    }
}
