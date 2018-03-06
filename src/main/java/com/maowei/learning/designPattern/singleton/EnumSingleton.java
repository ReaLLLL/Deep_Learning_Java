package com.maowei.learning.designPattern.singleton;

public class EnumSingleton {
    private enum SingletonEnum{
        singletonFactory;

        private Singleton instance;

        private SingletonEnum(){
            this.instance = new Singleton();
        }

        public Singleton getInstance() {
            return instance;
        }
    }

    public static Singleton getInstance(){
        return SingletonEnum.singletonFactory.getInstance();
    }
}

class Singleton{
    public Singleton(){
        System.out.println("Singleton的构造方法");
    }
}
