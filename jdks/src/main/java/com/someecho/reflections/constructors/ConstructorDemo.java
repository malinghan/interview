package com.someecho.reflections.constructors;

import com.someecho.reflections.domain.Foo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

/**
 * @author : linghan.ma
 * @Package com.someecho.reflections.constructors
 * @Description:
 * @date Date : 2020年03月14日 9:18 PM
 **/
public class ConstructorDemo {
    public static void main(String[] args) {
        for (Constructor<?> constructor : Foo.class.getConstructors()) {
            System.out.print(constructor.getName());
            System.out.print(" "+constructor.getParameterCount() );
            for (Type genericParameterType : constructor.getGenericParameterTypes()) {
                System.out.println(" "+genericParameterType.getTypeName());
            }
            System.out.println("");
        }
    }
}
