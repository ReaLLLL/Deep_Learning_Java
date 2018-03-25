package com.maowei.learning.designPattern.observer;

public class ConcreteObserver implements Observer{

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update() {
        System.out.println("My name is "+this.name);
        System.out.println("I've been notified by SMS");
    }
}
