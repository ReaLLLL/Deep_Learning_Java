package com.maowei.learning.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: ActionAspect.java, v 0.1 2017年12月19日 下午2:59:59 alexsong Exp $
 */
public class ActionAspectXML {

    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();//执行该方法
        System.out.println("退出环绕通知");
        return object;
    }

}
