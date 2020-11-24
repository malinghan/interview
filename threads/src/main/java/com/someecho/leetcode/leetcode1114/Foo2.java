package com.someecho.leetcode.leetcode1114;

/**
 * @author : linghan.ma
 * @Package com.someecho.leetcode.leetcode1114
 * @Description: 使用volatile实现
 * @date Date : 2020年11月23日 7:57 PM
 **/
public class Foo2 {
    private volatile int i = 1;
    
    public Foo2(){
    
    }
    
    public void first(Runnable pFirst) throws InterruptedException{
        while (i != 1);
        pFirst.run();
        i = 2;
    }
    
    public void second(Runnable pSecond)  throws InterruptedException{
        while ( i != 2);
        pSecond.run();
        i = 3;
    }
    
    public void third(Runnable pThird)  throws InterruptedException{
        while (i != 3);
        pThird.run();
    }
    
    public static void main(String[] args) throws InterruptedException {
        Runnable a = () -> System.out.println("first");
        Runnable b = () -> System.out.println("second");
        Runnable c = () -> System.out.println("third");
        final Foo2 foo = new Foo2();
        
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
