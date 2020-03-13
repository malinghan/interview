package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月24日 7:09 PM
 * 定义一个尾部指针 tail
 * 定义p用于存放slow的next指针的地址
 **/
public class LinkReverse {

    public static  Node reverse(Node  head){
        Node slow = head;
        Node tail = null;
        while (slow != null){
            Node p = slow.next;
            slow.next = tail;
            tail = slow;
            slow = p;
        }
        return  tail;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(6);
        Node newHead =  reverse(head);
        while (newHead.next!=null){
            System.out.println(newHead.data);
            newHead = newHead.next;
        }
    }
}
