package com.maowei.learning.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: AopTest.java, v 0.1 2017年12月19日 下午3:08:08 alexsong Exp $
 */
public class AopTest {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-aop.xml");
        AopActionInf a = (AopActionInf)ctx.getBean("actionImpl");
        a.doSomething_01();
    }
}
