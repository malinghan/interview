package com.someecho.leetcode.leetcode1114;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : linghan.ma
 * @Package com.someecho.leetcode.leetcode1114
 * @Description:
 * @date Date : 2020年11月24日 4:30 PM
 **/
public class LockFoo {
    int num;
    Lock lock;
    //精确的通知和唤醒线程
    Condition condition1, condition2, condition3;
    
    
    public LockFoo(){
        num = 1;
        lock = new ReentrantLock();
        condition1 = lock.newCondition();
        condition2 = lock.newCondition();
        condition3 = lock.newCondition();
    }
    
    public void first(Runnable pFirst) throws InterruptedException{
        lock.lock();
        try {
            while (num != 1){
                condition1.await();
            }
            pFirst.run();
            num = 2;
            condition2.signal();
        }catch (Exception e){
          e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    
    public void second(Runnable pSecond)  throws InterruptedException{
        lock.lock();
        try {
            while (num != 2){
                condition2.await();
            }
            pSecond.run();
            num = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    
    public void third(Runnable pThird)  throws InterruptedException{
        lock.lock();
        try {
            while (num != 3){
                condition3.await();
            }
            pThird.run();
            num = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Runnable a = () -> System.out.println("first");
        Runnable b = () -> System.out.println("second");
        Runnable c = () -> System.out.println("third");
        final LockFoo foo = new LockFoo();
        
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
