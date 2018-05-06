package com.maowei.learning.designPattern.templateMethod;

public class TemplateMethodTest {
    public static void main(String[] args) {
        ConcreteMethod01 c1 = new ConcreteMethod01();
        ConcreteMethod02 c2 = new ConcreteMethod02();

        c1.templateMethod();
        System.out.println("\n====================\n");
        c2.templateMethod();
    }
}
