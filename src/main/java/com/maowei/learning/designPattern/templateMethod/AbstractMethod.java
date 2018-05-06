package com.maowei.learning.designPattern.templateMethod;

public abstract class AbstractMethod {
    final void templateMethod(){
        System.out.println("调用模板方法开始");
        subMethod();
        System.out.println("调用模板方法结束");
    }

    public abstract void subMethod();
}
