package com.maowei.learning.designPattern.ResponsibilityChain;

public class ResponsibilityChainTest {
    public static void main(String[] args) {
        Handler handler01 = new ConcreteHandler01();
        Handler handler02 = new ConcreteHandler02();

        handler01.setSuccessor(handler02);

        System.out.println(handler01.handleRequest());
    }
}
