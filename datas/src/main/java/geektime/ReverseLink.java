package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2020年02月19日 4:52 PM
 **/
public class ReverseLink {

    public ListNode Reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTemp = curr.next;
             curr.next = prev;
             prev = curr;
             curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(7);
        ReverseLink reverseLink = new ReverseLink();
        head = reverseLink.Reverse(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}
