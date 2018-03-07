package com.maowei.learning.designPattern.abstractFactory;

public class FamilyCarEngine extends AbstractCarEngine{
    private String id;
    private String brand;
    private String type;

    public FamilyCarEngine(String brand, String type){
        this.id = String.valueOf(Math.random()*10000);
        this.brand = brand;
        this.type = type;
    }

    public void getCarEngineInfo() {
        System.out.println("The id of engine is "+this.id);
        System.out.println("The brand of engine is "+this.brand);
        System.out.println("The type of engine is "+this.type);
    }
}
