package com.someecho.java8.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author : linghan.ma
 * @Package com.someecho.java8.function
 * @Description:
 * @date Date : 2020年11月20日 3:47 PM
 **/
public class BiFunctionTest {

    public static void main(String[] args) {
        BiFunctionTest test2 = new BiFunctionTest();
        //使用BiFunction来完成
        System.out.println(test2.compute3(1,2,(value1,value2)-> value1 + value2));
        System.out.println(test2.compute3(1,2,(value1,value2)-> value1 - value2));
        System.out.println(test2.compute3(1, 2, (value1, value2) -> value1 * value2));
        System.out.println(test2.compute3(1, 2, (value1, value2) -> value1 / value2));

        //使用BiFunction中的andThen.
        System.out.println(test2.compute4(2,3,(value1,value2)->value1+value2,value -> value*value));
    }

    //BiFunction类的使用。 有两个输入参数
    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    /**
     * 2,3 -> 5 -> 25
     * @param a
     * @param b
     * @param biFunction
     * @param function
     * @return
     */
    public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer,Integer> function) {
        return biFunction.andThen(function).apply(a,b);
    }
}
