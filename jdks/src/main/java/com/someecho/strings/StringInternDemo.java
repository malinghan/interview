package com.someecho.strings;

/**
 * @author : linghan.ma
 * @Package com.someecho.strings
 * @Description:
 * @date Date : 2020年11月26日 11:52 AM
 **/
public class StringInternDemo {
    
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s1 = "1";
        System.out.println((s == s1));
        
        String s3 = new String("1")+new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println((s3 == s4));
    }
}
