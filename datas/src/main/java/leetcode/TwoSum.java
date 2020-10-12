package leetcode;

import java.util.HashMap;

/**
 * @author : linghan.ma
 * @Package data.map
 * @Description:
 * @date Date : 2020年09月17日 11:00 PM
 **/
public class TwoSum {
        public boolean isAnagram(String s, String t) {
            HashMap<Character,Integer> cache1   = toHashMap(s);
            HashMap<Character,Integer> cache2   = toHashMap(t);

            if(cache1.size() != cache2.size()){
                return false;
            }
            //比对
           for(Character key :cache1.keySet()){
                 if(!cache1.get(key).equals(cache2.get(key))){
                     return false;
                 }
            }

            int [] aaa = new int[2];

            cache2.equals(cache1);
            return true;
        }

        private static  HashMap<Character,Integer> toHashMap(String s){
            HashMap<Character,Integer> cache1 = new HashMap();
            for(int i = 0; i< s.length(); i++){
                if(cache1.containsKey(s.charAt(i))){
                    cache1.put(s.charAt(i),cache1.get(s.charAt(i))+1);
                }else{
                    cache1.put(s.charAt(i),1);
                }
            }
            return cache1;
        }
}
