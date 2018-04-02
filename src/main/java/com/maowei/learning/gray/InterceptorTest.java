package com.maowei.learning.gray;

import com.maowei.learning.aop.AopActionInf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InterceptorTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-interceptor.xml");
        AopActionInf a = (AopActionInf)ctx.getBean("action");
        a.doSomething_01();
    }
}
