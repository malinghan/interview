package com.someecho.spring03;

/**
 * @author : linghan.ma
 * @Package com.someecho.spring03
 * @Description:
 * @date Date : 2020年11月17日 4:25 AM
 **/
public interface Test {

    @Transaction
    public void method1();

    @Log
    public void method2();

    @Transaction
    @Log
    public void method3();

    @Log
    @Transaction
    public void method4();
}
