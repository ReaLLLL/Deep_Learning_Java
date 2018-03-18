package com.maowei.learning.designPattern.decorator;

public class Mocha extends Decorator{
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return 0.2 + this.beverage.cost();
    }
}
