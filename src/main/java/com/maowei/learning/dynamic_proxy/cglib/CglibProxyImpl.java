package com.maowei.learning.dynamic_proxy.cglib;

import com.maowei.learning.dynamic_proxy.ActionInf;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: CglibProxyImpl.java, v 0.1 2017年12月19日 上午11:17:17 alexsong Exp $
 */
public class CglibProxyImpl implements MethodInterceptor {
    private ActionInf object;

    public CglibProxyImpl(ActionInf object) {
        this.object = object;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("======before invoke======");

        ActionInf res = (ActionInf) methodProxy.invokeSuper(o, objects);

        System.out.println("======after invoke======");

        return res;
    }

    public ActionInf getProxyObject(){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(this.object.getClass());

        enhancer.setCallback(this);

        return (ActionInf)enhancer.create();
    }
}
