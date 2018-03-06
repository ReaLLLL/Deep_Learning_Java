package com.maowei.learning.designPattern;

public class SportsCar extends CarInf{

    public SportsCar(String brand, String color){
        System.out.println("Producing a sports car");
        this.brand = brand;
        this.color = color;
    }
}
