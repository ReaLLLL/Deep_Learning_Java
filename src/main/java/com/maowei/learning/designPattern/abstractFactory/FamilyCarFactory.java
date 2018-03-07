package com.maowei.learning.designPattern.abstractFactory;

public class FamilyCarFactory implements AbstractCarFactory{

    public AbstractCarEngine buildCarEngine() {
        return new FamilyCarEngine("FORD", "TSI");
    }

    public AbstractCarBody buildCarBody() {
        return new FamilyCarBody("FORD","STEEL");
    }
}
