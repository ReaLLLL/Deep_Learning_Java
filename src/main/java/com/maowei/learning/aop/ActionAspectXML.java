package com.maowei.learning.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: ActionAspect.java, v 0.1 2017年12月19日 下午2:59:59 alexsong Exp $
 */
public class ActionAspectXML {

    public void beforeMethod(String name){
        System.out.println("前置通知，请求参数："+name);
    }

    public void beforeMethod(){
        System.out.println("前置通知");
    }

    public void afterReturningMethod(){
        System.out.println("后置通知");
    }

    public void afterMethod(){
        System.out.println("最终通知");
    }

    public void afterThrowMethod(){
        System.out.println("例外通知");
    }

    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();//执行该方法
        System.out.println("退出方法");
        return object;
    }
}
