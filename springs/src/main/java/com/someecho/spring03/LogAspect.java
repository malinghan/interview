package com.someecho.spring03;

/**
 * @author : linghan.ma
 * @Package com.someecho.spring03
 * @Description:
 * @date Date : 2020年11月17日 4:25 AM
 **/
public class LogAspect implements Aspect {
    @Override
    public void before() {
        System.out.println("start log");
    }

    @Override
    public void after() {
        System.out.println("end log");
    }
}
