package com.someecho.reflections1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : linghan.ma
 * @Package com.someecho.reflections1
 * @Description:
 * @date Date : 2020年12月07日 1:14 PM
 **/
public class Demo02 {
    
    public static void main(String[] args) throws ClassNotFoundException {
        Class s = MyObject.class;
    
        print(s);
    
        System.out.println("======================");
        
        Class clazz = Class.forName("com.someecho.reflections1.MyObject");
        
        print(clazz);
    
    }
    
    public static void print(Class s){
        System.out.println(s);
        System.out.println(s.getName());
        System.out.println(s.getSimpleName());
        System.out.println(s.getModifiers());
        System.out.println(s.getPackage());
        //父类
        System.out.println(s.getSuperclass());
    
        for (final Class anInterface : s.getInterfaces()) {
            System.out.println(anInterface);
        }
        for (final Constructor constructor : s.getConstructors()) {
            System.out.println(constructor);
        }
    
        for (final Method method : s.getMethods()) {
            System.out.println(method);
        }
    
        for (final Field field : s.getFields()) {
            System.out.println(field);
        }
    
        for (final Annotation annotation : s.getAnnotations()) {
            System.out.println(annotation);
        }
        
    }
}
