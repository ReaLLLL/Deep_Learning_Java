package com.maowei.learning.innerClass;

/*
 * 匿名内部类
 * */
public class OutClass04 {
    public void print(InnerClass04 in){
        in.show();
    }

    public static void main(String[] args) {
        OutClass04 out = new OutClass04();
        out.print(new InnerClass04(){
            //内部类主体
            public void show(){
                System.out.println("在匿名内部类中");
            }
        });
    }
}

class InnerClass04{
    public void show(){
        System.out.println("在InnerClass04类中");
    }
}