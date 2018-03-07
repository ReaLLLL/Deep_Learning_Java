package com.maowei.learning.designPattern.factoryMethod;

public class FamilyCar extends CarInf{
    public FamilyCar(String brand, String color){
        System.out.println("Producing a family car");
        this.brand = brand;
        this.color = color;
    }
}
