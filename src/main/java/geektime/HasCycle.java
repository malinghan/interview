package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月25日 4:22 PM
 **/
public class HasCycle {

    public static boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast == null || slow == null || fast.next == null){
               return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return  true;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode next1 = new ListNode(5);
//        head.next = next1;
//        next1.next = head;
//        ListNode next2 = new ListNode(6);
//        next1.next = next2;
//        next2.next = head;
        System.out.println(hasCycle(head));
    }
}
