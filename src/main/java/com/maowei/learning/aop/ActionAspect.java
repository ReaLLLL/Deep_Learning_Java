package com.maowei.learning.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: ActionAspect.java, v 0.1 2017年12月19日 下午2:59:59 alexsong Exp $
 */
@Aspect
public class ActionAspect {

    @Pointcut("execution(* com.maowei.learning.aop.ActionImpl.*(..))")
    private void anyMethod(){}

    @Before("anyMethod() && args(name)")
    public void beforeMethod(String name){
        System.out.println("前置通知，请求参数："+name);
    }

    @AfterReturning("anyMethod()")
    public void afterReturningMethod(){
        System.out.println("后置通知");
    }

    @After("anyMethod()")
    public void afterMethod(){
        System.out.println("最终通知");
    }

    @AfterThrowing("anyMethod()")
    public void afterThrowMethod(){
        System.out.println("例外通知");
    }

    @Around("anyMethod()")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();//执行该方法
        System.out.println("退出方法");
        return object;
    }
}
