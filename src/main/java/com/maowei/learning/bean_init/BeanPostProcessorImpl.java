package com.maowei.learning.bean_init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

public class BeanPostProcessorImpl extends CommonAnnotationBeanPostProcessor {
    public BeanPostProcessorImpl(){
        super();
        System.out.println("这是BeanPostProcessor实现类构造器！！");
    }

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return super.postProcessBeforeInitialization(o, s);
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return super.postProcessAfterInitialization(o,s);
    }
}
