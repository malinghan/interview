package com.someecho.leetcode.leetcode1115;

import java.util.concurrent.Semaphore;

/**
 * @author : linghan.ma
 * @Package com.someecho.leetcode.leetcode1115
 * @Description:
 * @date Date : 2020年11月24日 5:00 PM
 **/
public class SemaphoreFooBar {
    private int n;
    //这里很巧妙: foo的permission为1
    private Semaphore fooSemaphore = new Semaphore(1);
    private Semaphore barSemaphore = new Semaphore(0);
    
    
    public SemaphoreFooBar(int n) {
        this.n = n;
    }
    
    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
                fooSemaphore.acquire();
                printFoo.run();
                barSemaphore.release();
        }
    }
    
    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                barSemaphore.acquire();
                printBar.run();
                fooSemaphore.release();
            }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Runnable a = () -> System.out.print("foo");
        Runnable b = () -> System.out.print("bar");
        int n = 100;
        final SemaphoreFooBar foo = new SemaphoreFooBar(n);
        
        new Thread(() -> {
            try {
                foo.foo(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
        new Thread(() -> {
            try {
                foo.bar(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
