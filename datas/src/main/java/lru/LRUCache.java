package lru;

import java.util.Map;

/**
 * @author : linghan.ma
 * @Package lru
 * @Description:
 * @date Date : 2020年12月06日 12:45 PM
 **/
public class LRUCache<K,V> {
    private int capacity;
    private Map<K, V> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new java.util.LinkedHashMap<K, V> (capacity, 0.75f, true) {
            // 定义put后的移除规则，大于容量就删除eldest
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }
    public V get(K key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else
            return null;
    }
    public void set(K key, V value) {
        cache.put(key, value);
    }
}
