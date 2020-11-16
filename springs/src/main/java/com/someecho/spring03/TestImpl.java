package com.someecho.spring03;

/**
 * @author : linghan.ma
 * @Package com.someecho.spring03
 * @Description:
 * @date Date : 2020年11月17日 5:30 AM
 **/
public class TestImpl implements Test {
    @Override
    @Transaction
    public void method1() {
        System.out.println("m1");
    }

    @Override
    @Log
    public void method2() {
        System.out.println("m2");
    }

    @Override
    @Transaction
    @Log
    public void method3() {
        System.out.println("m3");
    }

    @Override
    @Log
    @Transaction
    public void method4() {
        System.out.println("m4");
    }
}
