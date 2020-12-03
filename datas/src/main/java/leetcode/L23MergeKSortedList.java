package leetcode;

import geektime.ListNode;

import java.util.PriorityQueue;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description:
 * @date Date : 2020年12月04日 1:38 AM
 **/
public class L23MergeKSortedList {
    
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
    
    
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(7);
    
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(9);
    
        ListNode l3 = new ListNode(5);
        l3.next = new ListNode(6);
        l3.next.next = new ListNode(9);
    
        lists[0] =l1;
        lists[1] =l2;
        lists[2] =l3;
    
        ListNode newNode = new L23MergeKSortedList().mergeKSortedList(lists);
        while (newNode.next != null){
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
        int i = 1+1;
    }
    
    public ListNode mergeKSortedList(ListNode[] lists){
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,(o1,o2) ->{
                if(o1.val < o2.val){ return  -1;}
                else if(o1.val == o2.val){ return 0;}
                else{ return 1;}
            });
        for(ListNode listNode:lists){
            if(listNode !=null){
                queue.add(listNode);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (!queue.isEmpty()){
               p.next = queue.poll();
               p = p.next;
               if(p.next !=null){
                   queue.add(p.next);
               }
        }
        return  dummy.next;
    }
}
