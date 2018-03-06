package com.maowei.learning.jvm;

public class ParentInitialOrder {
    private static String staticField = "Parent Static Field Initial";

    private String field = "Parent Field Initial";

    static {
        System.out.println(staticField);
        System.out.println("Parent Static Patch Initial");
    }

    {
        System.out.println(field);
        System.out.println("Parent Field Patch Initial");
    }

    public ParentInitialOrder() {
        System.out.println("Parent Structure Initial ");
    }
}
