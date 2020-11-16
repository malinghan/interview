package com.someecho.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : linghan.ma
 * @Package com.someecho.leetcode
 * @Description:
 * 两个不同的线程将会共用一个 FooBar 实例。
 * 其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * @date Date : 2020年10月30日 5:30 PM
 **/
public class FooBar {

    private ReentrantLock lock = new ReentrantLock();
    private Condition fooCondition = lock.newCondition();
    private Condition barCondition = lock.newCondition();
    private int count = -1;

    private int n;

    public FooBar(int n){
        this.n  = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(count != 1){
                fooCondition.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            barCondition.signal();
            count = 2;
            printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if(count != 2){
                barCondition.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooCondition.signal();
            count = 1;
            lock.unlock();
        }
    }

    public static void main(String[] args)  throws InterruptedException {
        FooBar fooBar = new FooBar(10);
        Thread threadA = new Thread(() -> {
            System.out.println("foo");
        });
        Thread threadB = new Thread(() ->{
            System.out.println("bar");
        });
        fooBar.foo(threadA);
        fooBar.bar(threadB);
        threadA.start();
        threadB.start();
        threadA.run();
        threadB.run();
    }


}

