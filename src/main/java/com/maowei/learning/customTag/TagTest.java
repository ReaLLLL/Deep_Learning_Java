package com.maowei.learning.customTag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TagTest {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-tag.xml");
        Person p = (Person)ctx.getBean("a00001");
        System.out.println(p.toString());
    }
}
