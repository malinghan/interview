package com.someecho.reflections.methods;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.someecho.reflections.domain.Foo;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author : linghan.ma
 * @Package com.someecho.reflections.methods
 * @Description: 方法的属性和动态调用
 * @date Date : 2020年03月14日 8:41 PM
 **/
public class MethodDemo {

    public static void main(String[] args) throws ClassNotFoundException,NoSuchMethodException,
            InstantiationException,IllegalAccessException,InvocationTargetException {
        Class aClass = Class.forName("com.someecho.reflections.domain.Foo");
        System.out.println("getDeclaredMethods====================");
        for (Method declaredMethod : aClass.getDeclaredMethods()) {
            System.out.println(declaredMethod.getName());
        }
        Method method = aClass.getMethod("setName",String.class);


        System.out.println(method.getParameterCount()+" ");

        for (Parameter parameter : method.getParameters()) {
            System.out.println(parameter.getName()+"=="+parameter.getParameterizedType()
            +"==="+parameter.getAnnotatedType());
            for (Annotation annotation : parameter.getAnnotations()) {
                System.out.println(annotation.toString());
                System.out.println(annotation.annotationType());
            }
            System.out.println(method.getReturnType());
            System.out.println(method.getGenericReturnType());
            for (Annotation[] parameterAnnotation : method.getParameterAnnotations()) {
                System.out.println(parameterAnnotation.length);
            }
        }
        Foo foo1 =(Foo) aClass.newInstance();
        method.invoke(foo1,"小米");
        System.out.println(foo1.getName());
    }
}
