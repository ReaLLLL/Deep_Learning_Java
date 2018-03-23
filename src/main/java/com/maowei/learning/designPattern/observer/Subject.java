package com.maowei.learning.designPattern.observer;

public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObserver();
}