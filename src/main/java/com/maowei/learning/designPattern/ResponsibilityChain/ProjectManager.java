package com.maowei.learning.designPattern.ResponsibilityChain;

public class ProjectManager extends Handler{
    public String handleRequest(int amount) {
        System.out.println("当前处理人：项目经理");

        if(amount < 1000){
            return "审批通过";
        }else {
            System.out.println("金额超限，已流转至部门经理");
            return getSuccessor().handleRequest(amount);
        }
    }
}
