## 题目背景

## 题目描述
给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。

说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
## 题解

### 解法1：

#### 思路
一、设快慢指针slow和fast，让fast先走n-1步，然后再同时后移快慢指针，当快指针移到链表末尾的时候，慢指针所指向的节点就是要删除的节点；

二、但要是删除链表的最后一个元素，即n=1的时候，快慢指针方法就会出现问题，因为fast开始不移动，和慢指针一起后移到最后一个节点的时候要删除最后一个节点，在删除最后一个节点的时候，删除操作会出现空指针报错，所以行不通；

所以当要删除最后一个节点的时候就是最简单的遍历链表删除，让fast指针先走一步，然后一起移动，再进行删除操作。
#### 代码
```java
public class RemoveNthFromEnd{
public ListNode removeNthFromEnd(ListNode head, int n)
{
   if (n == 1)  //如果是删除最后一个节点，就遍历删除
   {
       if (head == null || head.next == null)
           return null;
       ListNode Pre = head;
       ListNode temp = head.next;
       while (temp.next != null)
       {
           temp = temp.next;
           Pre = Pre.next;
       }
       Pre.next = null;
       return head;
   }
   int k = n - 1;
   ListNode slow = head;
   ListNode fast = head;
   for (int i = 0; i < k; i++)
   {
       fast = fast.next;
   }
   while (fast.next != null)
   {
       fast = fast.next;
       slow = slow.next;
   }
   slow.val = slow.next.val;
   slow.next = slow.next.next;
   return head;
}
}
```
