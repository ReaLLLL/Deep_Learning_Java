package com.maowei.learning.designPattern.observer;

public class ConcreteObserver implements Observer{
    public void update() {
        System.out.println("I've been notified!");
    }
}
