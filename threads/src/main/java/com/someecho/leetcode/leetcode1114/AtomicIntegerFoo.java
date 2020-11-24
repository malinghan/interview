package com.someecho.leetcode.leetcode1114;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : linghan.ma
 * @Package com.someecho.leetcode.leetcode1114
 * @Description:  使用AtomicInteger(官方推荐)
 * 为了防止出现并发竞争状态，需要一种具有两种功能的机制：
 * 1）关键部分的访问控制；
 * 2）通知阻塞线程。
 * @date Date : 2020年11月23日 7:20 PM
 **/
public class AtomicIntegerFoo {
    
    private AtomicInteger firstJobDone = new AtomicInteger(0);
    
    private AtomicInteger secondJobDone = new AtomicInteger(0);
    
    public AtomicIntegerFoo(){
    
    }
    
    public void first(Runnable pFirst) throws InterruptedException{
        pFirst.run();
        firstJobDone.incrementAndGet();
    }
    
    public void second(Runnable pSecond)  throws InterruptedException{
        while (firstJobDone.get() != 1){
        
        }
        pSecond.run();
        secondJobDone.incrementAndGet();
    }
    
    public void third(Runnable pThird)  throws InterruptedException{
        while (secondJobDone.get() != 1){
        
        }
        pThird.run();
    }
    
    public static void main(String[] args) throws InterruptedException {
        Runnable a = () -> System.out.println("first");
        Runnable b = () -> System.out.println("second");
        Runnable c = () -> System.out.println("third");
        final AtomicIntegerFoo foo = new AtomicIntegerFoo();
    
        new Thread(() -> {
            try {
                foo.second(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    
        new Thread(() -> {
            try {
                foo.first(a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    
        new Thread(() -> {
            try {
                foo.third(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
