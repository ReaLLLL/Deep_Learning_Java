package com.maowei.learning.bean_init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Person implements BeanNameAware, BeanFactoryAware,InitializingBean, DisposableBean{
    private String name;
    private int age;

    private BeanFactory beanFactory;
    private String beanName;

    public Person(){
        System.out.println("【构造器】调用Person的构造器实例化");
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】注入属性name");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("【注入属性】注入属性age");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    public void init(){
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    public void  cleanUp(){
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("【PostConstruct注解】调用<bean>的PostConstruct注解指定的方法");
    }

    @PreDestroy
    public void  preDestroy(){
        System.out.println("【PreDestroy注解】调用<bean>的PreDestroy注解指定的方法");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    public void setBeanName(String s) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = s;
    }
}