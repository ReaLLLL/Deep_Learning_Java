package com.maowei.learning.designPattern.adaptor;

public class ConcreteAdaptor implements Adaptor {
    private Adaptee adaptee;

    public ConcreteAdaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void doSomething() {
        this.adaptee.adaptedOperation();
    }
}
