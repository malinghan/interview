package data.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : linghan.ma
 * @Package data.map
 * @Description:
 * @date Date : 2020年12月04日 7:10 PM
 **/
public class LinkedHashDemo1 {
    
    public static void main(String[] args) {
//        testHashMapOrder();
        testLinkedHashMapOrder();
    }
    
    private static void testHashMapOrder() {
        Map<String,String> map = new HashMap<>();
        map.put("aaa","a1");
        map.put("bbb","b1");
        map.put("ccc","c1");
        map.put("ddd","d1");
        map.put("eee","e1");
        
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
    
    private static void testLinkedHashMapOrder() {
        Map<String,String> map = new LinkedHashMap<String,String>(16,0.75f,true);
        map.put("aaa","a1");
        map.put("bbb","b1");
        map.put("ccc","c1");
        map.put("ddd","d1");
        map.put("eee","e1");
    
        map.get("ddd");
        map.get("ccc");
        
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
    
    private static void testLinkedHashMapLRU() {
        Map<String,String> map = new LinkedHashMap<String,String>(
                16,0.75f,true){
        };
        map.put("aaa","a1");
        map.put("bbb","b1");
        map.put("ccc","c1");
        map.put("ddd","d1");
        map.put("eee","e1");
        
        map.get("ddd");
        map.get("ccc");
        
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
