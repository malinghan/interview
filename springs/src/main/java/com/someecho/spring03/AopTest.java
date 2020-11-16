package com.someecho.spring03;

/**
 * @author : linghan.ma
 * @Package com.someecho.spring03
 * @Description:
 * @date Date : 2020年11月17日 4:27 AM
 **/
public class AopTest {

    public static void main(String[] args) {

        Test test = new Test() {
            @Override
            @Transaction
            public void method1() {
                System.out.println("m1");
            }

            @Override
            @Log
            public void method2() {
                System.out.println("m2");
            }

            @Override
            @Transaction
            @Log
            public void method3() {
                System.out.println("m3");
            }

            @Override
            @Log
            @Transaction
            public void method4() {
                System.out.println("m4");
            }
        };

        test.method1();

//        AopJDKDynamicProxyFactory invocationHandler = new AopJDKDynamicProxyFactory();
//        Test test1 = (Test)invocationHandler.bind(test);
//        test1.method1();

        AopJDKDynamicProxyFactory invocationHandler = new AopJDKDynamicProxyFactory();
        Test proxyInstance =  (Test)invocationHandler.bind(test);

//       Test proxyInstance =(Test) Proxy.newProxyInstance(Test.class.getClassLoader(),
//                new Class<?>[] {Test.class},
//                invocationHandler);
        System.out.println(proxyInstance.getClass());
        proxyInstance.method1();
        proxyInstance.method2();
        proxyInstance.method3();
        proxyInstance.method4();


        System.out.println("=================");

        Test cglibProxy = (Test) new AopCglibProxyFactory().getInstance(new TestImpl());
        System.out.println(cglibProxy.getClass());
        cglibProxy.method1();
        cglibProxy.method2();
        cglibProxy.method3();
        cglibProxy.method4();

    }
}
