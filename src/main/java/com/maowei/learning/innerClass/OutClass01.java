package com.maowei.learning.innerClass;

/*
* 成员内部类
* */
public class OutClass01 {
    private String name;
    private int age;

    public OutClass01(String name, int a){
        System.out.println("正在初始化外部类");
        this.name = name;
        this.age = age;
    }

    public void print(){
        System.out.println("外部类中的print方法");
        System.out.println("外部类中的name："+name);
        System.out.println("外部类中的age："+age);
    }



    class InnerClass01{
        public void print(){
            System.out.println("内部类中的print方法");
            System.out.println("内部类访问外部类中的name："+name);
            System.out.println("内部类访问外部类中的age："+age);
        }
    }

    public static void main(String[] args) {
        OutClass01 out = new OutClass01("Alex", 20);
        InnerClass01 in = out.new InnerClass01();
        out.print();
        in.print();
    }
}
