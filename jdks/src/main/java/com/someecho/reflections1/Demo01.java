package com.someecho.reflections1;

import java.lang.reflect.Method;

/**
 * @author : linghan.ma
 * @Package com.someecho.reflections1
 * @Description:
 * @date Date : 2020年12月07日 1:10 PM
 **/

/**
 * 在这个例子中通过调用MyObject类的class属性获取对应的Class类的对象，
 * 通过这个Class类的对象获取MyObject类中的方法集合。迭代这个方法的集合并且打印每个方法的名字。
 */
public class Demo01 {
    
    public static void main(String[] args) {
        Method[] methods = MyObject.class.getMethods();
        //only print public
        for (final Method method : methods) {
            System.out.println("method="+method.getName());
        }
    }
}
