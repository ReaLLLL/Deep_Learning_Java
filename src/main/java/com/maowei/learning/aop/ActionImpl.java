package com.maowei.learning.aop;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: ActionImpl.java, v 0.1 2017年12月19日 下午2:55:55 alexsong Exp $
 */
public class ActionImpl implements AopActionInf{
    public void doSomething_01() {
        System.out.println("this is method doSomething_01");
    }

    public void doSomething_02(String arg1) {
        System.out.println("this is method doSomething_02");
        System.out.println("arg1 is "+arg1);
    }

    public void doSomething_03(String arg1, String arg2) {
        System.out.println("this is method doSomething_03");
        System.out.println("arg1 is "+arg1);
        System.out.println("arg2 is "+arg2);
    }

    public void doSomething_04(String arg1, String arg2, String arg3) {
        System.out.println("this is method doSomething_03");
        System.out.println("arg1 is "+arg1);
        System.out.println("arg2 is "+arg2);
        System.out.println("arg3 is "+arg3);
    }
}
