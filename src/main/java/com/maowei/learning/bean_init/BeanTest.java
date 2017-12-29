package com.maowei.learning.bean_init;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    public static void main(String[] args) throws Exception{

        System.out.println("现在开始初始化容器");

        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-bean-init.xml");

        System.out.println("容器初始化成功");

        Person p = (Person)ctx.getBean("person02");
        System.out.println(p.toString());

//        p = (Person)ctx.getBean("person02");
//        System.out.println(p.toString());

        System.out.println("现在开始关闭容器！");

        ctx.registerShutdownHook();
    }
}
