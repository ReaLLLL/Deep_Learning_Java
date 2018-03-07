package com.maowei.learning.designPattern.abstractFactory;

public class SportCarBody extends AbstractCarBody{
    private String id;
    private String brand;
    private String type;

    public SportCarBody(String brand, String type){
        this.id = String.valueOf(Math.random()*10000);
        this.brand = brand;
        this.type = type;
    }

    public void getCarBodyInfo() {
        System.out.println("The id of body is "+this.id);
        System.out.println("The brand of body is "+this.brand);
        System.out.println("The type of body is "+this.type);
    }
}
