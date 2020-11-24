package com.someecho.leetcode.leetcode1114;

import java.util.concurrent.CountDownLatch;

/**
 * @author : linghan.ma
 * @Package com.someecho.leetcode.leetcode1114
 * @Description:
 * @date Date : 2020年11月24日 4:44 PM
 **/
public class CountDownLatchFoo {
    CountDownLatch countDownLatch12,countDownLatch23;
    
    public CountDownLatchFoo(){
        //初始的允许请求均设为0
        countDownLatch12 = new CountDownLatch(1);
        countDownLatch23 = new CountDownLatch(1);
    }
    
    public void first(Runnable pFirst) throws InterruptedException{
        // printFirst.run() outputs "first". Do not change or remove this line.
        pFirst.run();
        //释放一个12的信号量
        countDownLatch12.countDown();
    }
    
    public void second(Runnable pSecond)  throws InterruptedException{
        countDownLatch12.await();
        pSecond.run();
        countDownLatch23.countDown();
    }
    
    public void third(Runnable pThird)  throws InterruptedException{
        countDownLatch23.await();
        pThird.run();
    }
    
    public static void main(String[] args) throws InterruptedException {
        Runnable a = () -> System.out.println("first");
        Runnable b = () -> System.out.println("second");
        Runnable c = () -> System.out.println("third");
        final CountDownLatchFoo foo = new CountDownLatchFoo();
        
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
