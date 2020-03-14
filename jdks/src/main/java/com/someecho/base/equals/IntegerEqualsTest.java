package com.someecho.base.equals;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.equals
 * @Description:
 * @date Date : 2019年09月18日 2:19 AM
 **/
public class IntegerEqualsTest {
    public static void main(String[] args) {
        Integer  i = 100;
        Integer i1 = 100;
        System.out.println((i == i1));
        System.out.println(i.equals(i1));
        System.out.println(i1.hashCode());
        Integer  m = 1000;
        Integer m1 = 1000;
        System.out.println((m == i1));
        System.out.println(i.equals(i1));
        System.out.println(i1.hashCode());
    }
}
