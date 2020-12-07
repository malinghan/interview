package com.someecho.base.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : linghan.ma
 * @Package com.someecho.base.hash
 * @Description: 测试hash
 * @date Date : 2019年09月18日 1:16 AM
 **/
public class HashingTest {
    

    public static void main(String[] args) {
        
        Map<DataKey, Integer> hm = HashingTest.getAllData();

        DataKey dk = new DataKey();
        dk.setId(1);
        dk.setName("Pankaj");
        System.out.println(dk.hashCode());

        Integer value = hm.get(dk);

        System.out.println(value);
    }


    private static Map<DataKey, Integer> getAllData() {
        Map<DataKey, Integer> hm = new HashMap();

        DataKey dk = new DataKey();
        dk.setId(1);
        dk.setName("Pankaj");
        System.out.println(dk.hashCode());

        hm.put(dk, 10);

        return hm;
    }
}



