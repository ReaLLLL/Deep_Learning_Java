package com.maowei.learning.designPattern.ResponsibilityChain;

public class ConcreteHandler02 extends Handler{
    public String handleRequest() {
        System.out.println("操作者02：处理通过");
        if(null != getSuccessor())
            return getSuccessor().handleRequest();
        else
            return "处理通过并结束";
    }
}
