package com.someecho.leetcode.leetcode1114;

import java.util.concurrent.Semaphore;

/**
 * @author : linghan.ma
 * @Package com.someecho.leetcode.leetcode1114
 * @Description:
 * @date Date : 2020年11月24日 4:36 PM
 **/
public class SemaphoreFoo {
    
    Semaphore semaphore12, semaphore23;
    
    public SemaphoreFoo(){
        //初始的允许请求均设为0
        semaphore12 = new Semaphore(0);
        semaphore23 = new Semaphore(0);
    }
    
    public void first(Runnable pFirst) throws InterruptedException{
        // printFirst.run() outputs "first". Do not change or remove this line.
        pFirst.run();
        //释放一个12的信号量
        semaphore12.release();
    }
    
    public void second(Runnable pSecond)  throws InterruptedException{
       semaphore12.acquire();
        pSecond.run();
       semaphore23.release();
    }
    
    public void third(Runnable pThird)  throws InterruptedException{
        semaphore23.acquire();
        pThird.run();
    }
    
    public static void main(String[] args) throws InterruptedException {
        Runnable a = () -> System.out.println("first");
        Runnable b = () -> System.out.println("second");
        Runnable c = () -> System.out.println("third");
        final SemaphoreFoo foo = new SemaphoreFoo();
        
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
