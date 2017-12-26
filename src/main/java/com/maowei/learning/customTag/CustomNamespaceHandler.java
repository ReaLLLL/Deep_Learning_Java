package com.maowei.learning.customTag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class CustomNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        System.out.println("开始解析自定义命名空间");
        registerBeanDefinitionParser("person", new PersonBeanDefinitionParser());
    }
}
