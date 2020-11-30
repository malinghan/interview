package com.someecho.leetcode.leetcode1115;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : linghan.ma
 * @Package com.someecho.leetcode.leetcode1115
 * @Description:
 * @date Date : 2020年11月24日 7:06 PM
 **/
public class CountDownLatchFooBar {
    private int n;
    
    
    volatile boolean fin = true;
    
    private CyclicBarrier cyclicBarrier;
    
    public CountDownLatchFooBar(int n) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    }
    
    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
                while (!fin);
                printFoo.run();
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.run();
            fin = true;
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Runnable a = () -> System.out.print("foo");
        Runnable b = () -> System.out.print("bar");
        int n = 100;
        final CountDownLatchFooBar foo = new CountDownLatchFooBar(n);
    
        new Thread(() -> {
            try {
                foo.bar(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
        new Thread(() -> {
            try {
                foo.foo(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
    }
}
