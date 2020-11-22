package com.someecho.base.equals;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.equals
 * @Description: 测试string的equals方法
 * @date Date : 2019年09月18日 2:16 AM
 **/
public class StringEqualsTest {
    public static void main(String[] args) {
        String a = "aaa";
        String a1 = "aaa";
        String  a2 = new String("aaa");
        System.out.println("a == a1:"+(a == a1));
        System.out.println("a.equals(a1):" + a.equals(a1));
        System.out.println("hashcode a vs a1:"+(a.hashCode() == a1.hashCode()));
        System.out.println("a==a2:"+(a == a2));
        System.out.println("a.equals(a2)="+a.equals(a2));
        System.out.println("hashcode a vs a2:"+(a.hashCode() == a2.hashCode()));
    }
}
