package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description: 回文链表
 * 拓展: 求回文链表的相遇点(数学追击问题)
 * @date Date : 2019年12月24日 6:35 PM
 **/
public class Palindrome {

    public static boolean check(Node head){
        if(head == null || head.next == null){
            return true;
        }
        //1. 快慢指针求中点
        Node fast = head;
        Node slow = head;
        while(fast!= null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse
        Node tail = null;
        while (slow != null){
            Node p = slow.next;
            slow.next = tail;
            tail = slow;
            slow = p;
        }
        slow = tail;
        //compare
        fast = head;
        while(fast != null && slow != null){
            if(fast.data != slow.data){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        //2. 翻转
        //3. 比对
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
        System.out.println(check(head));
    }
}
