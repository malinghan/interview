package com.someecho.spring03;

/**
 * @author : linghan.ma
 * @Package com.someecho.spring03
 * @Description:
 * @date Date : 2020年11月17日 4:24 AM
 **/
public class TransactionAspect implements Aspect {

    @Override
    public void before() {
        System.out.println("start transaction");
    }

    @Override
    public void after() {
        System.out.println("end transaction");
    }
}
