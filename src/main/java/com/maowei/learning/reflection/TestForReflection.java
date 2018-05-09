package com.maowei.learning.reflection;

import com.maowei.learning.reflection.pojo.Designer;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestForReflection {
    public static void main(String[] args) {

        //第一种获取Class对象方式
        Designer designer = new Designer("A001","Alex","Designer", 30);
        Class designerClass1 = designer.getClass();
        //System.out.println(designerClass1.getName());

        //第二种获取Class对象方式
        Class designerClass2 = Designer.class;
        //System.out.println(designerClass2.getName());

        //第三种获取Class对象方式
        try {
            Class designerClass3 = Class.forName("com.maowei.learning.reflection.pojo.Designer");
            //System.out.println(designerClass3.getName());

            /*Constructor[] conArr = designerClass3.getConstructors();
            for(Constructor c : conArr)
                System.out.println(c);

            System.out.println("===============这是分割线===============");

            conArr = designerClass3.getDeclaredConstructors();
            for(Constructor c : conArr)
                System.out.println(c);

            System.out.println("===============这是分割线===============");

            Constructor constructor = designerClass3.getConstructor(String.class,String.class,String.class, int.class);
            System.out.println(constructor);
            constructor.setAccessible(true);
            Object obj1 = constructor.newInstance("A001","Alex","Designer", 30);

            System.out.println("===============这是分割线===============");

            constructor = designerClass3.getDeclaredConstructor();
            System.out.println(constructor);
            Object obj2 = constructor.newInstance();*/


            /*Constructor constructor = designerClass3.getConstructor(String.class,String.class,String.class, int.class);
            Object obj1 = constructor.newInstance("A001","Alex","Designer", 30);

            Method[] methods = designerClass3.getMethods();
            for(Method m : methods){
                System.out.println(m);
            }

            System.out.println("===============这是分割线===============");

            methods = designerClass3.getDeclaredMethods();
            for(Method m : methods){
                System.out.println(m);
            }

            Method method = designerClass3.getMethod("doWorking");
            method.invoke(obj1);

            System.out.println("===============这是分割线===============");

            method = designerClass3.getDeclaredMethod("working02");
            method.setAccessible(true);
            method.invoke(obj1);*/

            Constructor constructor = designerClass3.getConstructor(String.class,String.class,String.class, int.class);
            System.out.println(constructor);
            constructor.setAccessible(true);
            Object obj1 = constructor.newInstance("A001","Alex","Designer", 30);

            Field[] fields = designerClass3.getFields();
            for(Field f : fields){
                System.out.println(f);
            }

            System.out.println("===============这是分割线===============");

            fields = designerClass3.getDeclaredFields();
            for(Field f : fields){
                System.out.println(f);
            }

            Field f = designerClass3.getField("age");
            f.set(obj1, 31);

            System.out.println("===============这是分割线===============");

            f = designerClass3.getDeclaredField("id");
            f.setAccessible(true);
            f.set(obj1,"A002");



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
