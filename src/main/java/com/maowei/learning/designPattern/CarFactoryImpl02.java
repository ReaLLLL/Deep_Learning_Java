package com.maowei.learning.designPattern;

public class CarFactoryImpl02 implements CarFactoryInf{
    private String factoryName;

    public CarFactoryImpl02(String factoryName){
        this.factoryName = factoryName;
        System.out.println("The chosen factory name is "+ this.factoryName);
    }


    public CarInf produceCar(String brand, String color) {
        return new FamilyCar(brand, color);
    }
}
