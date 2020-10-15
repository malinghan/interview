package com.someecho;

/**
 * @author : linghan.ma
 * @Package com.someecho
 * @Description: 循环+算术运算+类型转换
 * @date Date : 2020年10月16日 1:09 AM
 **/
public class ForLoopTest {
    private static int[] numbers = {1,6,8};

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        for (int number : numbers) {
            ma.submit(number);
        }
        double avg = ma.getAvg();
    }
}
