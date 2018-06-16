package com.maowei.learning.aop;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: ActionImpl.java, v 0.1 2017年12月19日 下午2:55:55 alexsong Exp $
 */
public class AopActionImpl implements AopActionInf{
    public void doSomething_01() {
        System.out.println("AopActionImpl.doSomething_01()");
        this.doSomething_02();
    }

    public void doSomething_02() {
        System.out.println("AopActionImpl.doSomething_02()");
    }
}
