package com.maowei.learning.aop;

public aspect AopAspectJDemo {
    pointcut demo(): execution(* com.maowei.learning.aop.AopActionImpl.*(..));

    Object around(): demo(){
        System.out.println("进入环绕通知");
        Object object  = proceed();//执行该方法
        System.out.println("退出方法");
        return object;
    }
}
