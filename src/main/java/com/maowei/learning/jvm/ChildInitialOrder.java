package com.maowei.learning.jvm;

public class ChildInitialOrder extends ParentInitialOrder {
    private static String staticField = "Child Static Field Initial";

    private String field = "Child Field Initial";



    static {
        System.out.println(staticField);
        System.out.println("Child Static Patch Initial");
    }



    public ChildInitialOrder() {
        System.out.println("Child Structure Initial ");
    }

    public static void main(String argv[]) {
        new ChildInitialOrder();
    }

    {
        System.out.println(field);
        System.out.println("Child Field Patch Initial");
    }
}
