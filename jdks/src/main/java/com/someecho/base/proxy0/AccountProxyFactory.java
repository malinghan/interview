package com.someecho.base.proxy0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.proxy0
 * @Description:
 * @date Date : 2019年09月25日 5:30 PM
 **/
public class AccountProxyFactory implements InvocationHandler {

     private Object target;

     public Object bind(Object target){
         this.target = target;
         return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
     }

     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
         boolean objFlag = method.getDeclaringClass().getName().equals("java.lang.Object");

         Object result = null;

         if(!objFlag){
             System.out.println("proxy before");
             result = method.invoke(this.target,args);
         }
         return  result;
     }
}
