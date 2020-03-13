package geektime;

import java.util.List;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月24日 8:22 PM
 **/
public class MergeTwoSortedLink {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode tmp = new ListNode(-1);
        ListNode res = tmp;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                res.next = p1;
                p1 = p1.next;
            } else {
                res.next = p2;
                p2 = p2.next;
            }
            res = res.next;
        }
        if (p1 != null) {
            res.next = p1;
        }
        if (p2 != null) {
            res.next = p2;
        }
        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(5);
        ListNode newHead = mergeTwoLists(l1, l2);
        while (newHead.next != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
