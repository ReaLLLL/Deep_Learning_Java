package com.maowei.learning.designPattern.ResponsibilityChain;

public class GeneralManager extends Handler{
    public String handleRequest(int amount) {
        System.out.println("当前处理人：总经理");

        return "审批通过";
    }
}
