package com.someecho.base.stati;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.stati
 * @Description:
 * @date Date : 2019年09月25日 3:21 PM
 **/
public class Father {
    private static String val;
    static {
        val = "a";
        System.out.println("1");
    }

    {
        System.out.println("3");
    }

    public Father(){
        System.out.println("13");
    }

    public void print(){
        System.out.println("4");
    }

    public static void staticPrint(){
        System.out.println("18");
    }
}
