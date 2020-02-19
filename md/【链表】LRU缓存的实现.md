## 题目背景
  实现LRU缓存，就是保证基本的get和set的功能的同时，
  还要保证最近访问(get或put)的节点保持在限定容量的Cache中，
  如果超过容量则应该把LRU(近期最少使用)的节点删除掉
## 题目描述

Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

**get(key)**
 - Get the value (will always be positive) of the key if the key exists in the cache, 
 otherwise return -1.

**set(key, value)**
 - Set or insert the value if the key is not already present. 
 When the cache reached its capacity, it should invalidate the least recently 
 used item before inserting a new item.
 
 ![aa](/src/main/java/image/LRU.png)
## 题解

### 解法1：基于HashMap和双向链表的实现

#### 思路
- HashMap存储数据,head、tail指针定义队头和队尾
#### 代码
```java
public class LRUCache {
    class Node {
        Node pre;
        Node next;
        Integer key;
        Integer val;
        public Node(){}
        public Node(Integer k, Integer v) {
            key = k;
            val = v;
        }
    }
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    // The head (eldest) of the doubly linked list.
    Node head;
    // The tail (youngest) of the doubly linked list.
    Node tail;
    int cap;
    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }
    public int get(int key) {
        Node n = map.get(key);
        if(n!=null) {
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return n.val;
        }
        return -1;
    }
    public void set(int key, int value) {
        Node n = map.get(key);
        // existed
        if(n!=null) {
            n.val = value;
            map.put(key, n);
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return;
        }
        // else {
        if(map.size() == cap) {
            Node tmp = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            map.remove(tmp.key);
        }
        n = new Node(key, value);
        // youngest node append taill
        appendTail(n);
        map.put(key, n);
    }
    private void appendTail(Node n) {
        n.next = tail;
        n.pre = tail.pre;
        tail.pre.next = n;
        tail.pre = n;
    }
}
```
### 解法2:基于LinkedHashMap的实现

#### 思路
- HashMap+双向链表？这不就是LinkedHashMap吗！
- 将 accessOrder 设为true，他就会在get和put操作时进行lru相关的操作
- removeEldestEntry如果大于capacity就开始移除
#### 代码

```java
public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new java.util.LinkedHashMap<Integer, Integer> (capacity, 0.75f, true) {
            // 定义put后的移除规则，大于容量就删除eldest
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else
            return -1;
    }
    public void set(int key, int value) {
        cache.put(key, value);
    }
}
```