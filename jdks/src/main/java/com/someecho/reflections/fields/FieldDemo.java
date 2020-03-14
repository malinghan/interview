package com.someecho.reflections.fields;

import com.someecho.reflections.domain.Foo;

import java.lang.reflect.Field;

/**
 * @author : linghan.ma
 * @Package com.someecho.reflections.fields
 * @Description:
 * @date Date : 2020年03月14日 8:56 PM
 **/
public class FieldDemo {

    public static void main(String[] args) {
        Foo foo1 = new Foo();
        for (Field field : foo1.getClass().getFields()){
            System.out.print(field.getName());
            System.out.print(" "+field.getType());
            System.out.print(" "+field.getAnnotatedType());
        }

        for (Field field : foo1.getClass().getDeclaredFields()) {
            System.out.print(field.getName());
            System.out.print(" "+field.getDeclaringClass());
            System.out.print(" "+field.getAnnotatedType());
        }
    }
}
