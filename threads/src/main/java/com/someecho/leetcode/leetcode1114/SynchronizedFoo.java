package com.someecho.leetcode.leetcode1114;

/**
 * @author : linghan.ma
 * @Package com.someecho.leetcode.leetcode1114
 * @Description:
 * @date Date : 2020年11月24日 4:25 PM
 **/
public class SynchronizedFoo {
    private boolean firstFinished;
    private boolean secondFinished;
    private Object lock = new Object();
    
    public SynchronizedFoo(){
    
    }
    
    public void first(Runnable pFirst) throws InterruptedException{
        synchronized (lock){
            pFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }
    }
    
    public void second(Runnable pSecond)  throws InterruptedException{
        synchronized (lock){
            while (!firstFinished){
                lock.wait();
            }
            pSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }
    
    public void third(Runnable pThird)  throws InterruptedException{
        synchronized (lock) {
            while (!secondFinished){
                lock.wait();
            }
            pThird.run();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Runnable a = () -> System.out.println("first");
        Runnable b = () -> System.out.println("second");
        Runnable c = () -> System.out.println("third");
        final SynchronizedFoo foo = new SynchronizedFoo();
        
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
