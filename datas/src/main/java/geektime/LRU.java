package geektime;

import java.util.LinkedHashMap;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description: 实现一个Lru cache
 * @date Date : 2019年12月24日 3:10 PM
 **/
public class LRU {
    private final int CAPACITY = 0;
    private LinkedHashMap<Integer, Integer> cache;

    public LRU(int capacity) {

        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

}