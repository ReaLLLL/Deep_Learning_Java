package com.maowei.learning.designPattern.abstractFactory;

public class SportsCarFactory implements AbstractCarFactory{

    public AbstractCarEngine buildCarEngine() {
        return new SportCarEngine("PORSCHE","TSI");
    }

    public AbstractCarBody buildCarBody() {
        return new SportCarBody("PORSCHE","STEEL");
    }
}
