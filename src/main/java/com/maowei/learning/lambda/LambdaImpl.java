package com.maowei.learning.lambda;

public class LambdaImpl {
    public static void main(String[] args) {
        //LambdaInf l = ()-> System.out.print("This is a test!");
        LambdaInf l = (a,b)->a+b;
        System.out.print(l.doAddition(5,10));
    }
}
