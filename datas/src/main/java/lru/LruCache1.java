package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : linghan.ma
 * @Package lru
 * @Description:
 *  https://leetcode-cn.com/problems/lru-cache/
 *
 *  使用linkedHashMaps实现+泛型抽象
 * @date Date : 2020年12月05日 12:40 PM
 **/

public class LruCache1<K, V> extends LinkedHashMap<K, V> {
    
    private static final int MAX_NODE_NUM = 100;
    
    private int limit;
    
    public LruCache1() {
        this(MAX_NODE_NUM);
    }
    
    public LruCache1(int limit) {
        super(limit, 0.75f, true);
        this.limit = limit;
    }
    
    @Override
    public V put(K key, V val) {
        return super.put(key, val);
    }
    
    public V get1(K key) {
        return  super.getOrDefault(key,null);
    }
    
   
    
    /**
     * 判断节点数是否超限
     * @param eldest
     * @return 超限返回 true，否则返回 false
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }
}
