package com.maowei.learning.dynamic_proxy.jdk;

import com.maowei.learning.dynamic_proxy.ActionInf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: InvocationHandlerImpl.java, v 0.1 2017年12月19日 上午10:04:04 alexsong Exp $
 */
public class InvocationHandlerImpl implements InvocationHandler{
    private ActionInf object;

    public InvocationHandlerImpl(ActionInf object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("======before invoke======");

        Object res = method.invoke(this.object, args);

        System.out.println("======after invoke======");

        return res;
    }
}
