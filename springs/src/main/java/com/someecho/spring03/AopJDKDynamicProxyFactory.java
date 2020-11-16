package com.someecho.spring03;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.proxy0
 * @Description:
 * @date Date : 2019年09月25日 5:30 PM
 **/
public class AopJDKDynamicProxyFactory implements InvocationHandler {

     private Object target;

     public Object bind(Object target){
         this.target = target;
         return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
     }

     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
         Annotation[] annotations = method.getAnnotations();
         System.out.println(annotations);
         Transaction transactional = method.getAnnotation(Transaction.class);
         Log log = method.getAnnotation(Log.class);
         Object result = null;
         if(transactional != null){
             new TransactionAspect().before();
         }
         if(log != null){
             new LogAspect().before();
         }
         result = method.invoke(this.target,args);
         if(transactional != null){
             new TransactionAspect().after();
         }
         if(log != null){
             new LogAspect().after();
         }
         return  result;
     }
}
