package com.maowei.learning.designPattern.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new Mocha(beverage);
        beverage1 = new Mocha(beverage1);

        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());
    }
}
