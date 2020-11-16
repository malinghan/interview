package com.someecho.spring02;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Aop2使用注解的方式
 * pointcut -> 监听Klass的dong
 * before
 * after
 * around
 */
@Aspect
public class Aop2 {
    
    @Pointcut(value="execution(* com.someecho.*.Klass.*dong(..))")
    public void point(){
        
    }
    
    @Before(value="point()")
    public void before(){
        System.out.println("========>begin klass dong...");
    }
    
    @AfterReturning(value = "point()")
    public void after(){
        System.out.println("========>after klass dong...");
    }
    
    @Around("point()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("========>around begin klass dong");
        joinPoint.proceed();
        System.out.println("========>around after klass dong");
        
    }
    
}
