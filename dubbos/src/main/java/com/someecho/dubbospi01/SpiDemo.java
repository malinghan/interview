package com.someecho.dubbospi01;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author : linghan.ma
 * @Package com.someecho.dubbo01
 * @Description: https://blog.csdn.net/qq_35190492/article/details/108256452
 * @date Date : 2020年11月20日 10:47 AM
 **/
public class SpiDemo {

    public static void main(String[] args) {
        ServiceLoader<Aobing> serviceLoader = ServiceLoader.load(Aobing.class);
        Iterator<Aobing> iterator = serviceLoader.iterator();
        while (iterator.hasNext()){
            Aobing aobing = iterator.next();
            aobing.say();
        }
    }
}
