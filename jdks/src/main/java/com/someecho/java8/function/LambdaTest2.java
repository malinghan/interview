package com.someecho.java8.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//解释一下，JAVA的lambda的类型是一个对象
public class LambdaTest2 {
    public static void main(String[] args) {

        //函数式接口的实现 1.lambda方式   （）方法的参数 {}方法的实现
        TheInterface i1 = () -> {};

        System.out.println(i1.getClass().getInterfaces()[0]);

        TheInterface2 i2 = () -> {};
        System.out.println(i2.getClass().getInterfaces()[0]);

        //必须要通过上下文，来完成类型的推断。上面的lambda是推断出来的，下面这种就是有问题的。
        //() -> {};


        //通过lambda实现一个线程。     //Runnable runnable;源码里面已经更改为 函数式接口
        new Thread(()->{
            System.out.println("hello world");
        }).start();


        //传统方式，转换大写，  遍历，转换，输出
        List<String> list = Arrays.asList("hello","worild","hello world");
        list.forEach(item ->{
            System.out.println(item.toUpperCase());
        });

        //把list 转换成大写，放入list1 ，然后输出
        List<String> list1 = new ArrayList<>(); //diamond语法  类型推断带来的好处
        list.forEach(item -> list1.add(item.toUpperCase()));
        list1.forEach(System.out::println);

        //新的方式，采用流的方式去编写。 流与lambda表达式，集合，密切相关。 先体验一下流带来的便利性
//        list.stream().map(item -> item.toUpperCase()).forEach(item-> System.out.println(item.toUpperCase()));
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        
    }
}

@FunctionalInterface
interface TheInterface{
    void myMethod();
}

@FunctionalInterface
interface TheInterface2{
    void myMethod2();
}

