package com.someecho.reflections.classs;

import com.someecho.reflections.domain.Foo;
import com.someecho.reflections.util.ClassUtil;

/**
 * @author : linghan.ma
 * @Package com.someecho.reflections.classs
 * @Description: 学习类类型
 * @date Date : 2020年03月14日 8:15 PM
 **/
public class ClassDemo {

    public static void main(String[] args){
        //class的调用方式
        Class fooClass = Foo.class;
        Foo foo1 = new Foo();
       Class foo1Class1 = foo1.getClass();

       try {
           Class fooClass2 = Class.forName("com.someecho.reflections.domain.Foo");
           System.out.println("fooClass2="+fooClass2);
           System.out.println(foo1Class1 == fooClass2);
       }catch (ClassNotFoundException e){
           //
       }
        System.out.println(fooClass);
        System.out.println(foo1Class1);
        System.out.println(foo1Class1 == fooClass);

        System.out.println("=======================");
        ClassUtil.print(foo1);
    }
}
