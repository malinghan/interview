# 题目
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
实现 LRUCache 类：

LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 

进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？

# 题意分析

LRUCache具有固定的缓存大小,每次
- get、put时都会把操作的元素放在队列头部

伪代码
```
build: 
     - DoublyLinkedNode(prev next key value)
     - size
     - DoublyLinkedNode head
     - DoublyLinkedNode tail
get -> contains(key)? 
                     yes -> remove(node) ,addToFirst()
                     no ->  -1
put -> contains(key)?
                    yes ->  remove(node) ,addToFirst(), changeVaule,map.put
                    no -> if(size() > size) remove(tail.prev) addToFirst(),map.put
                                          ->  addToFirst(),map.put                 
```

# 解题报告
## 思路1
HashMap+双链表


get ->

## 思路2
extends LinkedHashMap
重写 removeEldestEntry

