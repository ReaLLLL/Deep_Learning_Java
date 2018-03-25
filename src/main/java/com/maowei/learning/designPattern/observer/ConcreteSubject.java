package com.maowei.learning.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{
    private List<Observer> list;

    public ConcreteSubject(){
        this.list = new ArrayList<Observer>();
    }

    public void addObserver(Observer observer) {
        this.list.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.list.remove(observer);
    }

    public void notifyObserver() {
        for (Observer o : this.list){
            o.update();
        }
    }
}
