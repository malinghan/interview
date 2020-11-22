package com.someecho.java8.function;

/**
 * @author : linghan.ma
 * @Package com.someecho.java8.function
 * @Description:
 * @date Date : 2020年11月20日 4:18 PM
 **/
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = p -> ( p.length() > 5);

        System.out.println(predicate.test("hello"));

    }
}