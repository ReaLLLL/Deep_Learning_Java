package com.maowei.learning.designPattern.singleton;

import java.io.Serializable;

public class InnerClassSingleton implements Serializable{
    private static class Singleton{
        private static final InnerClassSingleton _instance = new InnerClassSingleton();
    }

    private InnerClassSingleton(){
        if(null != Singleton._instance){
            throw new RuntimeException("单例模式被侵犯");
        }
    }

    public static InnerClassSingleton getInstance(){
        return Singleton._instance;
    }

    private Object readResolve(){
        return Singleton._instance;
    }
}
