package com.maowei.learning.customTag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class PersonBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    protected Class getBeanClass(Element element){
        return Person.class;
    }

    protected void doParse(Element element, BeanDefinitionBuilder bean){
        System.out.println("开始注册BeanDefinition信息");

        String name = element.getAttribute("name");
        String age = element.getAttribute("age");

        if(StringUtils.hasText(name))
            bean.addPropertyValue("name", name);

        if(StringUtils.hasText(age))
            bean.addPropertyValue("age", Integer.valueOf(age));
    }
}
