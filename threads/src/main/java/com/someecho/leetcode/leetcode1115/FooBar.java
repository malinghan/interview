package com.someecho.leetcode.leetcode1115;

/**
 * @author : linghan.ma
 * @Package com.someecho.leetcode.leetcode1115
 * @Description:
 * 1115. 交替打印FooBar
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 * 两个不同的线程将会共用一个 FooBar 实例。
 * 其中一个线程将会调用 foo() 方法，
 * 另一个线程将会调用 bar() 方法。
 * @date Date : 2020年11月24日 4:51 PM
 **/
public class FooBar {
    private int n;
    
    private Object lock = new Object();
    
    private int flag = 0;
    
    public FooBar(int n) {
        this.n = n;
    }
    
    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while(flag != 0){
                    lock.wait();
                }
                printFoo.run();
                flag = 1;
                lock.notifyAll();
            }
        }
    }
    
    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                while(flag != 1){
                    lock.wait();
                }
                printBar.run();
                flag = 0;
                lock.notifyAll();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Runnable a = () -> System.out.print("foo");
        Runnable b = () -> System.out.print("bar");
        int n = 100;
        final FooBar foo = new FooBar(n);
        
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
