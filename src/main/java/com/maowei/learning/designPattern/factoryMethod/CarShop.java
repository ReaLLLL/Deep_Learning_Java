package com.maowei.learning.designPattern.factoryMethod;

import com.maowei.learning.designPattern.CarFactoryImpl01;
import com.maowei.learning.designPattern.CarFactoryImpl02;
import com.maowei.learning.designPattern.CarFactoryInf;
import com.maowei.learning.designPattern.CarInf;

public class CarShop {
    private CarFactoryInf carFactory;

    public CarShop(CarFactoryInf carFactory){
        this.carFactory = carFactory;
    }

    public void sellCar(){
        CarInf inf = this.carFactory.produceCar("Audi", "red");
        inf.getCarInfo();
    }

    public static void main(String[] args) {
        CarFactoryInf inf = new CarFactoryImpl01("AAA");
        CarShop test = new CarShop(inf);
        test.sellCar();

        inf = new CarFactoryImpl02("BBB");
        test = new CarShop(inf);
        test.sellCar();

    }
}
