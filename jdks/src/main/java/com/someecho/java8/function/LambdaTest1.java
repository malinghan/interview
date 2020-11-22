package com.someecho.java8.function;

/**
 * @author : linghan.ma
 * @Package com.someecho.java8.function
 * @Description:
 * @date Date : 2020年11月20日 4:56 PM
 **/
public class LambdaTest1 {
    @FunctionalInterface
    interface MyInterface {
        void test();

        String toString();
    }

    public void myTest(MyInterface myInterface){
        System.out.println("1");
        myInterface.test();
        System.out.println("2");
    }

        public static void main(String[] args) {
            LambdaTest1 test2 = new LambdaTest1();
            //1.默认调用接口里面的接口函数。默认调用MyTest接口里面的test方法。
            //2.如果没有参数传入方法，那么可以直接使用（）来表达，如下所示
            test2.myTest(()-> System.out.println("mytest"));

            MyInterface myInterface = () -> {
                System.out.println("hello");
            };

            System.out.println(myInterface.getClass()); //查看这个类
            System.out.println(myInterface.getClass().getSuperclass());//查看类的父类
            System.out.println(myInterface.getClass().getInterfaces()[0]);// 查看此类实现的接口
        }
}
