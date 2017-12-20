package com.maowei.learning.proxy;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: ProxyTest.java, v 0.1 2017年12月20日 上午10:28:28 alexsong Exp $
 */
public class ProxyTest {
    public static void main(String[] args){

        //根据真实对象创建一个代理对象
        ProxySubject proxy = new ProxySubject(new RealSubject());

        //通过访问代理对象实现对真实对象的访问
        proxy.doSomething();
    }
}
