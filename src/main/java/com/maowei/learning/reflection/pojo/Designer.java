package com.maowei.learning.reflection.pojo;

import com.maowei.learning.reflection.Work;

public class Designer extends Employee implements Work{
    public String hobby;
    private int age;

    public Designer(String id, String name, String hobby, int age){
        super(id, name);
        this.hobby = hobby;
        this.age = age;
    }

    private Designer(){
        super("A000","unknown");
        this.hobby = "";
        this.age = 0;
    }

    protected Designer(String hobby, int age){
        super("A000","unknown");
        this.hobby = hobby;
        this.age = age;
    }

    public void doWorking() {
        System.out.println("I'm designing!");
    }

    protected void working01(){
        System.out.println("this is a protected method!");
    }

    private void working02(){
        System.out.println("this is a private method!");
    }
}
