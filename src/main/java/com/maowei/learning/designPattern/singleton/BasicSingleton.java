package com.maowei.learning.designPattern.singleton;

public class BasicSingleton {
    private static BasicSingleton instance;

    private BasicSingleton(){}

    public static BasicSingleton getInstance(){
        if(null == instance)
            instance = new BasicSingleton();

        return instance;
    }
}
