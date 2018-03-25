package com.maowei.learning.designPattern.adaptor;

public class AdaptorTest {
    public static void main(String[] args) {
        Adaptee adaptee = new ConcreteAdaptee();

        Adaptor adaptor = new ConcreteAdaptor(adaptee);

        adaptor.doSomething();
    }
}
