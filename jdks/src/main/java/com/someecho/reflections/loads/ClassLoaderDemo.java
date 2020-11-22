package com.someecho.reflections.loads;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.someecho.reflections.loads
 * @Description: 如何证明方法的反射调用是动态加载？
 * 泛型定义了List存储的是String,但是反射将其改为Integer
 * @date Date : 2020年03月14日 9:01 PM
 **/
public class ClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException,NoSuchMethodException,Exception{
        List<String> sss = new ArrayList<>();
        Method method1 = sss.getClass().getMethod("add",Object.class);
        method1.invoke(sss,2);
        //泛型定义了List存储的是String,但是反射将其改为Integer
        System.out.println(sss);

         Class list  = Class.forName("java.util.ArrayList");
         List<?> lis1 = (List<?>) list.newInstance();
         Method method = list.getMethod("add",Object.class);
         method.invoke(lis1,"蛇");
        System.out.println(lis1);
    }
}
