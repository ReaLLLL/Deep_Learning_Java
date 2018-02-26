package com.maowei.learning.jvm;

public class ClassFile {
    public static void main(String[] args) {
        Base base = new Sub();
        System.out.println(base.x);
        base.func();
    }
}

class Base {

    public int x = 5;
    public void func(){
        System.out.println("This is a base class");
    }
}
class Sub extends Base{
    public int x = 6;
    public void func() {
        System.out.println("This is a sub class");
    }
}
