package com.maowei.learning.designPattern.abstractFactory;

public class CarPartShop {
    private AbstractCarFactory carFactory;

    public CarPartShop(AbstractCarFactory carFactory){
        this.carFactory = carFactory;
    }

    public void sellCarBody(){
        AbstractCarBody carBody = this.carFactory.buildCarBody();
        carBody.getCarBodyInfo();
    }

    public void sellCarEngine(){
        AbstractCarEngine carEngine = this.carFactory.buildCarEngine();
        carEngine.getCarEngineInfo();
    }

    public static void main(String[] args) {
        CarPartShop shop = new CarPartShop(new SportsCarFactory());
        shop.sellCarBody();
        shop.sellCarEngine();

        shop = new CarPartShop(new FamilyCarFactory());
        shop.sellCarBody();
        shop.sellCarEngine();

    }
}
