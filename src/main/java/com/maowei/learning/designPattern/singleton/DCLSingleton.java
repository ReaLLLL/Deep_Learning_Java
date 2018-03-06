package com.maowei.learning.designPattern.singleton;

import java.io.Serializable;

public class DCLSingleton implements Serializable{
    private static volatile DCLSingleton _instance;

    private DCLSingleton(){
        synchronized (DCLSingleton.class){
            if(null != _instance){
                throw new RuntimeException("单例模式被侵犯！");
            }
        }
    }

    public static DCLSingleton getInstance(){
        if(null == _instance){
            synchronized (DCLSingleton.class){
                if(null == _instance){
                    _instance = new DCLSingleton();
                    return _instance;
                }
            }
        }

        return _instance;
    }

    private Object readResolve() {
        return _instance;
    }
}
