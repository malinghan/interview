package com.someecho;

/**
 * @author : linghan.ma
 * @Package com.someecho
 * @Description:
 * @date Date : 2020年10月16日 12:56 AM
 **/
public class MovingAverage {
    private int count = 0;
    private double sum = 0.0D;

    public MovingAverage(){

    }

    public void submit(double value){
              this.count ++;
              this.sum += value;
    }

    public double getAvg(){
        if(0 == this.count){
            return sum;
        }
        return this.sum / this.count;
    }

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        int num1 = 1;
        int num2 = 2;
        ma.submit(num1);
        ma.submit(num2);
        double avg = ma.getAvg();
    }
}
