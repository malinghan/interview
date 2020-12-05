package lru;

import java.util.HashMap;

/**
 * @author : linghan.ma
 * @Package PACKAGE_NAME
 * @Description:
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 /* 缓存容量
 * cache.put(1,1);
    * cache.put(2,2);
    * cache.get(1);       // 返回  1
    * cache.put(3,3);    // 该操作会使得密钥 2 作废
    * cache.get(2);       // 返回 -1 (未找到)
    * cache.put(4,4);    // 该操作会使得密钥 1 作废
    * cache.get(1);       // 返回 -1 (未找到)
    * cache.get(3);       // 返回  3
    * cache.get(4);       // 返回  4
 *
 * 使用hashMap+双链表实现
 **/
public class LruCache<K,V> {
    /**
     * cache capacity
     */
    int size;
    
    /**
     * for lru search data
     */
    HashMap<K,DoublyLinkedNode> map = new HashMap<>();
    
    /**
     * for lru strategy
     */
    DoublyLinkedNode head = new DoublyLinkedNode(0,0);
    
    /**
     * for lru strategy
     */
    DoublyLinkedNode tail = new DoublyLinkedNode(0,0);
    
    
    /**
     * constructor with capacity
     * @param capacity
     */
    public LruCache(int capacity){
        this.size = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    
    /**
     * inner DoublyLinkedNode
     */
    class DoublyLinkedNode<K,V>{
        DoublyLinkedNode prev;
        DoublyLinkedNode next;
        K key;
        V value;
    
        /**
         * init DoublyLinkedNode using k,v
         * @param key
         * @param value
         */
        public DoublyLinkedNode(K key,V value){
            this.key = key;
            this.value = value;
        }
    }
    
    
    /**
     * if contains key,then remove,and addToFirst return value,
     * else return -1;
     *
     * remove:
     * @param key
     * @return
     */
    public V get(K key){
        if(map.containsKey(key)){
            DoublyLinkedNode node = map.get(key);
            remove(node);
            addFirst(node);
            map.put(key,node);
            return (V) node.value;
        }else {
            return  null;
        }
    }
    
    
    /**
     * if contains key,then change the value
     * else insert to last,
     *     if size is full ,then remove the last;
     * @param key
     * @param value
     */
    public void put(K key,V value){
        if(map.containsKey(key)){
            DoublyLinkedNode node = map.get(key);
            node.value = value;
            map.put(key,node);
        }else {
            if(map.size() >= size){
                remove(tail.prev);
            }
            DoublyLinkedNode newNode = new DoublyLinkedNode(key,value);
            addFirst(newNode);
            map.put(key,newNode);
        }
    }
    
    /**
     * remove node
     * @param node
     */
    private void remove(DoublyLinkedNode node){
        DoublyLinkedNode prev =  node.prev;
        DoublyLinkedNode next =  node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(node.key);
    }
    
    
    /**
     * add first node
     * @param node
     */
    private void addFirst(DoublyLinkedNode node){
        DoublyLinkedNode next = head.next;
        node.next = next;
        node.prev = head;
        head.next = node;
        next.prev = node;
    }
    
    public static void main(String[] args) {
    LruCache cache = new LruCache(2);
     cache.put(1,1);
     cache.put(2,2);
        System.out.println(cache.get(1));       // 返回  1
     cache.put(3,3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
     cache.put(4,4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
     cache.get(3);       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
