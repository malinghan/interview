package leetcode;

import geektime.ListNode;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description:
 * @date Date : 2020年10月30日 5:08 PM
 **/
public class DetectCycle {

    public static ListNode detectCycle(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        if(head.next.next == head){
            return head;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        ListNode meet = null;
        while(fast != null && fast.next != null){
            if(fast == slow){
                meet = fast;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if(meet != null){
            slow = head;
            while(meet != slow){
                meet = meet.next;
                slow = slow.next;
            }
            return meet;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(detectCycle(head).val);
    }
}
