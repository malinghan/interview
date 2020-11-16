package com.someecho.spring03;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.proxy0
 * @Description:
 * @date Date : 2019年09月25日 5:36 PM
 **/
public class AopCglibProxyFactory implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
//        return Enhancer.create(this.target.getClass(),this);

        Enhancer enhancer = new Enhancer(); //该类用于生成代理对象
        enhancer.setSuperclass(this.target.getClass()); //设置父类
        enhancer.setCallback(this); //设置回调对象为本身
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable{
        boolean objFlag =method.getDeclaringClass().getName().equals("java.lang.Object");

        if(!objFlag){
            System.out.println("before");
        }

        Object resule =null;
        Transaction transactional = method.getAnnotation(Transaction.class);
        Log log = method.getAnnotation(Log.class);
        Object result = null;
        if(transactional != null){
            new TransactionAspect().before();
        }
        if(log != null){
            new LogAspect().before();
        }
        resule =methodProxy.invokeSuper(o,objects);
        if(transactional != null){
            new TransactionAspect().after();
        }
        if(log != null){
            new LogAspect().after();
        }
        if(!objFlag){
            System.out.println("after");
        }
        return resule;
    }
}
