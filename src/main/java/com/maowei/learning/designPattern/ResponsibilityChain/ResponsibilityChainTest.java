package com.maowei.learning.designPattern.ResponsibilityChain;

public class ResponsibilityChainTest {
    public static void main(String[] args) {
        Handler projectManager = new ProjectManager();
        Handler deptManager = new DeptManager();
        Handler generalManager = new GeneralManager();

        projectManager.setSuccessor(deptManager);
        deptManager.setSuccessor(generalManager);

        System.out.println(projectManager.handleRequest(500));
        System.out.println("==========================\n");
        System.out.println(projectManager.handleRequest(1500));
        System.out.println("==========================\n");
        System.out.println(projectManager.handleRequest(3500));

    }
}
