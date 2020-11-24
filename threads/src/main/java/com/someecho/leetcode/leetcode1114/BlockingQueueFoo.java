package com.someecho.leetcode.leetcode1114;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author : linghan.ma
 * @Package com.someecho.leetcode.leetcode1114
 * @Description:
 * @date Date : 2020年11月24日 4:46 PM
 **/
public class BlockingQueueFoo {
    BlockingQueue<String> blockingQueue12,blockingQueue23;
    
    public BlockingQueueFoo(){
        //初始的允许请求均设为0
        blockingQueue12 = new SynchronousQueue<>();
        blockingQueue23 = new SynchronousQueue<>();
    }
    
    public void first(Runnable pFirst) throws InterruptedException{
        // printFirst.run() outputs "first". Do not change or remove this line.
        pFirst.run();
        //释放一个12的信号量
        blockingQueue12.put("stop");
    }
    
    public void second(Runnable pSecond)  throws InterruptedException{
        blockingQueue12.take();
        pSecond.run();
        blockingQueue23.put("stop");
    }
    
    public void third(Runnable pThird)  throws InterruptedException{
        blockingQueue23.take();
        pThird.run();
    }
    
    public static void main(String[] args) throws InterruptedException {
        Runnable a = () -> System.out.println("first");
        Runnable b = () -> System.out.println("second");
        Runnable c = () -> System.out.println("third");
        final BlockingQueueFoo foo = new BlockingQueueFoo();
        
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
