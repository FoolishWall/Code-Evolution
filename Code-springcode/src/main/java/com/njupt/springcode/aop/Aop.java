package com.njupt.springcode.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


/**
 * @author wall
 * @date 2019/7/20  15:33
 * @description
 */
@Aspect
public class Aop {
    @Pointcut("execution(public * com.njupt.springcode.aop.CalculateImp.*(..))")
    public void pointCut(){}

    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint){
        System.out.println("before方法");
    }

    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint){
        System.out.println("after方法");
    }
}
