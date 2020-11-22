package com.someecho.java8.function;

/**
 * @author : linghan.ma
 * @Package com.someecho.java8.function
 * @Description:
 * @date Date : 2020年11月20日 3:44 PM
 **/

import java.util.function.Function;

/**
 *  compose , andThen 方法的使用
 */
public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 test2 = new FunctionTest2();
        int compute = test2.compute(2, v -> v * 3, v -> v * v);//12
        int compute2 = test2.compute2(2, v -> v * 3, v -> v * v);//36
        System.out.println(compute);
        System.out.println(compute2);
    }

    /**
     * function1.compose(function2):先执行function2再执行function1
     * 2 -> 4 -> 12
     * @param a
     * @param function1
     * @param function2
     * @return
     */
    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }


    /**
     * function1.andThen(function2):先执行function1再执行function2
     * 2 -> 6 -> 36
     * @param a
     * @param function1
     * @param function2
     * @return
     */
    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }
}