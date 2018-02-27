package com.maowei.learning.innerClass;

/*
 * 方法内部类
 * */
public class OutClass03 {
    public void print(){
        final int a = 10;

        class InnerClass03{
            int b = 20;
            public void print(){
                //使用所在方法中的局部变量，那么就需要将这个局部变量定义为final的。
                System.out.println("访问内部类中的成员a："+a);
                System.out.println("访问内部类中的成员b："+b);
            }
        }

        InnerClass03 in = new InnerClass03();
        in.print();
    }

    public static void main(String[] args) {
        OutClass03 out = new OutClass03();
        out.print();
    }
}
