package com.maowei.learning.designPattern;

public abstract class CarInf {
    public String brand;
    public String color;

    public void getCarInfo() {
        System.out.println("The brand of car is "+this.brand);
        System.out.println("The color of car is "+this.color);
    }
}
