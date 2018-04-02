package com.maowei.learning.gray;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.util.Random;

public class ServiceMethodInterceptor implements MethodInterceptor{
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Method method = methodInvocation.getMethod();
        System.out.println(method.getName());

        Class<?> invocationClass = method.getDeclaringClass();
        System.out.println(invocationClass.getName());

        Object[] params = methodInvocation.getArguments();

        Random random = new Random();
        int nextVal = random.nextInt(10);

        if(nextVal > 5){
            System.out.println("随机值:"+nextVal);
            return methodInvocation.proceed();
        }else {
            System.out.println("随机值:"+nextVal);
            return null;
        }
    }
}
