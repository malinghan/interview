package com.someecho.reflections.util;

import java.lang.reflect.Method;

/**
 * @author : linghan.ma
 * @Package com.someecho.reflections.util
 * @Description:
 * @date Date : 2020年03月14日 8:27 PM
 **/
public class ClassUtil {

    public static  void print(Object obj){
      Class objClass =  obj.getClass();
        System.out.println(objClass.getPackage());//com.someecho.reflections.domain
        System.out.println(objClass.getName());//com.someecho.reflections.domain.Foo
        System.out.println(objClass.getSimpleName());//Foo
        System.out.println(objClass.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2

        for (Class declaredClass : objClass.getDeclaredClasses()) {
            System.out.println(declaredClass.getName());
        }
        System.out.println("getInterfaces================");
        for (Class anInterface : objClass.getInterfaces()) {
            System.out.println(anInterface.getName()+"==="+anInterface.getTypeName());

        }
        System.out.println("getMethods================");
        for (Method method : objClass.getMethods()) {
            System.out.println(method.getName());
            System.out.println(method.getGenericReturnType());
        }
        System.out.println("getDeclaredMethods==================");
        for (Method method : objClass.getDeclaredMethods()) {
            System.out.println(method.getName());
            System.out.println(method.getGenericReturnType());
        }
    }
}
