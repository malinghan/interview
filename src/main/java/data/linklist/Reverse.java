package data.linklist;

import java.util.List;

/**
 * @author : linghan.ma
 * @Package data.linklist
 * @Description:
 * @date Date : 2019年09月24日 2:27 AM
 *
 *  3 -> 2 -> 1 -> 4 ->  null
 *  3 <- 2 <- 1 <- 4
 *
 *  3 <- head
 *  temp -> 2 -> 1 -> 4
 *
 *
 *
 *  node
 *  temp
 *  n
 *  m
 **/
public class Reverse {

    public static void main(String[] args) {
         Node node  = new Node(3);
         node.setNext(new Node(2));
         node.getNext().setNext(new Node(1));
         node.getNext().getNext().setNext(new Node(4));
        System.out.println(reverse(node));
    }

    public static int reverse(Node head){
        Node pre = null;
        Node next = null;
        while (head!=null) {
          next =  head.getNext();
          head.setNext(pre);
          pre = head;
          head = next;

        }
        return pre.getData();
    }
}
