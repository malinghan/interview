package com.someecho.volatiles;

/**
 * @author : linghan.ma
 * @Package com.someecho.volatiles
 * @Description:
 * @date Date : 2020年11月26日 1:51 PM
 **/
public class VolatileDemo {
    
        private static int int1;
        private static int int2;
        private static int int3;
        private static int int4;
        private static int int5;
    
        public static void main(String[] args) throws InterruptedException {
            for (int i = 0; i < 10000; i++)
            {
                increase(i);
            }
            print();
            Thread.sleep(1000);
        }
    
        private static void increase(int i){
            int1= i+1;
            int2= i+2;
            int3= i+3;
            int4= i+4;
            int5= i+5;
        }
        
        private static void print(){
            System.out.println(int1);
            System.out.println(int2);
            System.out.println(int3);
            System.out.println(int4);
            System.out.println(int5);
        }
}
