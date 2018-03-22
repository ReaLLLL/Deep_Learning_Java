package com.maowei.learning.designPattern.observer;

public class ObserverTest {
    public static void main(String[] args) {
        Subject sbj = new ConcreteSubject();
        Observer obs = new ConcreteObserver();

        sbj.attach(obs);

        sbj.notifyObserver();
    }

}
