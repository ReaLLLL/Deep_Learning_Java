package com.maowei.learning.dynamic_proxy;

import com.maowei.learning.dynamic_proxy.cglib.CglibProxyImpl;
import com.maowei.learning.dynamic_proxy.jdk.InvocationHandlerImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: DynamicProxyTest.java, v 0.1 2017年12月19日 上午10:07:07 alexsong Exp $
 */
public class DynamicProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ActionImpl_01 a1 = new ActionImpl_01();
        ActionImpl_02 a2 = new ActionImpl_02();

        InvocationHandler handler1 = new InvocationHandlerImpl(a1);
        InvocationHandler handler2 = new InvocationHandlerImpl(a2);

        ClassLoader loader = a1.getClass().getClassLoader();
        Class[] interfaces = a1.getClass().getInterfaces();

        System.out.println("============以下是jdk测试代码============");

        ActionInf inf = (ActionInf) Proxy.newProxyInstance(loader, interfaces, handler1);

        inf.doSomething("world");

        System.out.println("============这是分割线============");

        Class proxyClass = Proxy.getProxyClass(ActionInf.class.getClassLoader(), ActionInf.class);

        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);

        inf = (ActionInf)constructor.newInstance(handler2);

        inf.doSomething("world");

        System.out.println("============以下是Cglib测试代码============");

        CglibProxyImpl cg = new CglibProxyImpl(a1);
        inf = cg.getProxyObject();
        inf.doSomething("World");

        System.out.println("============这是分割线============");

        cg = new CglibProxyImpl(a2);
        inf = cg.getProxyObject();
        inf.doSomething("World");
    }
}
