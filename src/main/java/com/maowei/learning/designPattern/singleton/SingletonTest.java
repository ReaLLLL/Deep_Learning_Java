package com.maowei.learning.designPattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SingletonTest {
    public static void main(String[] args) {
        try{
            Class clazz = Class.forName("com.maowei.learning.designPattern.singleton.HungrySingleton");

            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);

            Object obj1 = constructor.newInstance();
            Object obj2 = constructor.newInstance();
            //Object obj2 = DCLSingleton.getInstance();

            if(obj1 == obj2)
                System.out.println("the same object");
            else
                System.out.println("the different object");
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
