package com.someecho;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : linghan.ma
 * @Package com.someecho
 * @Description:
 * @date Date : 2020年10月25日 11:02 PM
 **/
public class KeylessEntry {

    static class Key{
            Integer id;

            Key(Integer id){
                this.id = id;
            }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

//        @Override
//        public boolean equals(Object obj) {
//            boolean response = false;
//            if(obj instanceof  Key){
//                response = (((Key)obj).id).equals(this.id);
//            }
//            return response;
//        }
    }

    public static void main(String[] args) {
        Map m = new HashMap<>();

        while (true){
            for (int i = 0; i < 10000; i++) {
                //contanisKey一直不等于,则会一直往map中放入元素，直到内存溢出
                if(!m.containsKey(new Key(i))){
                    m.put(new Key(i),"Number"+i);
                }
            }
            System.out.println("m.size():"+m.size());
        }
    }
}
