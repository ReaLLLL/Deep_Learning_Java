package com.maowei.learning.dynamic_proxy;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: ActionImpl_02.java, v 0.1 2017年12月19日 上午10:00:00 alexsong Exp $
 */
public class ActionImpl_02 implements ActionInf{
    public void doSomething(String word) {
        System.out.println(this.getClass().getName()+"::"+"Hello "+word);
    }
}