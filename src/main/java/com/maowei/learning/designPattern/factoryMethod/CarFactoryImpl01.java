package com.maowei.learning.designPattern.factoryMethod;

public class CarFactoryImpl01 implements CarFactoryInf{
    private String factoryName;

    public CarFactoryImpl01(String factoryName){
        this.factoryName = factoryName;
        System.out.println("The chosen factory name is "+ this.factoryName);
    }


    public CarInf produceCar(String brand, String color) {
        return new SportsCar(brand, color);
    }
}
