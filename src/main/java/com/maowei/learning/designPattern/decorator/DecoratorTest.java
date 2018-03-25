package com.maowei.learning.designPattern.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        //创建一个HouseBlend对象
        Beverage beverage = new HouseBlend();
        //用Mocha来修饰上述HouseBlend对象
        Beverage beverage1 = new Mocha(beverage);

        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        System.out.println("=====================================");

        //创建一个Espresso对象
        beverage = new Espresso();
        //用2份Mocha来修饰上述HouseBlend对象
        Beverage beverage2 = new Mocha(beverage);
        beverage2 = new Mocha(beverage2);

        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
