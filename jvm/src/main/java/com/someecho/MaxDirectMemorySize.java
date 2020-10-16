package com.someecho;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * @author : linghan.ma
 * @Package com.someecho
 * @Description: 分配堆外内存
 * @date Date : 2020年10月16日 10:21 AM
 **/
public class MaxDirectMemorySize {

    /**
     * direct ByteBuffer通过full gc来回收内存的，
     * direct ByteBuffer会自己检测情况而调用system.gc()，
     * 但是如果参数中使用了DisableExplicitGC那么就无法回收该快内存了，
     * -XX:+DisableExplicitGC标志自动将System.gc()调用转换成一个空操作，
     * 就是应用中调用System.gc()会变成一个空操作。那么如果设置了就需要我们手动来回收内存了
     * @param args
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        System.out.println("maxMemoryValue:" + sun.misc.VM.maxDirectMemory());


        System.out.println("================================");

        ByteBuffer buffer = ByteBuffer.allocateDirect(0);
        Class<?> c = Class.forName("java.nio.Bits");
        Field maxMemory = c.getDeclaredField("maxMemory");
        maxMemory.setAccessible(true);
        synchronized (c) {
            Long maxMemoryValue = (Long) maxMemory.get(null);
            System.out.println("maxMemoryValue:" + maxMemoryValue);
        }
    }

    }
