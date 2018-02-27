package com.maowei.learning.innerClass;

/*
* 静态内部类
* */
public class OutClass02 {
    private String name;
    private int age;
    private static String id = "0123456789";

    public OutClass02(String name, int a){
        System.out.println("正在初始化外部类");
        this.name = name;
        this.age = age;
    }

    public void print01(){
        System.out.println("外部类中的print方法");
        System.out.println("外部类中的name："+name);
        System.out.println("外部类中的age："+age);
    }

    public static void print02(){
        System.out.println("外部类中的print方法");
        System.out.println("外部类中的id："+id);
    }



    static class InnerClass02{
        public void print(){
            System.out.println("内部类中的print方法");
            print02();
        }
    }

    public static void main(String[] args) {
        InnerClass02 in = new InnerClass02();
        in.print();
    }
}
