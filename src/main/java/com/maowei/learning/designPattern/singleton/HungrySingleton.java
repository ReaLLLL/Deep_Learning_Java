package com.maowei.learning.designPattern.singleton;

public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
        if(null != instance){
            throw new RuntimeException("单例模式被破坏");
        }
        System.out.println("HungrySingleton 私有构造方法");
    }

    public static HungrySingleton getInstance(){
        return instance;
    }
}
