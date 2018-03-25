package com.maowei.learning.designPattern.observer;

public class ObserverTest {
    public static void main(String[] args) {
        Subject sbj = new ConcreteSubject();
        Observer obs01 = new ConcreteObserver("A");
        Observer obs02 = new ConcreteObserver("B");
        Observer obs03 = new ConcreteObserver("C");

        sbj.addObserver(obs01);
        sbj.addObserver(obs02);
        sbj.addObserver(obs03);

        sbj.notifyObserver();

        System.out.println("====================");

        sbj.removeObserver(obs02);
        sbj.notifyObserver();
    }
}
