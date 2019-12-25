package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月25日 5:13 PM
 **/
public class RemoveNthFromEnd {

    public  static ListNode removeNthFromEnd(ListNode head,int n){
        ListNode slow = head;
        ListNode pre = null;
        ListNode fast = head;
        if(n == 1){
            while(fast.next != null){
                fast = fast.next;
            }
            return fast;
        }else {
            int c = 0;
            while(c != (n -1)){
                c++;
                if(fast == null){
                    return  null;
                }
                fast = fast.next;

            }
            while(fast.next != null){
                fast = fast.next;
                pre = slow;
                slow = slow.next;
            }
            //remove
            pre.next = slow.next;
            return slow;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println(removeNthFromEnd(head,5).val);
    }
}
