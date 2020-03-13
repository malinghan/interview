package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月23日 4:16 PM
 **/
public class Josephus {
    /**
     * @total 总人数
     * @from 从第几个人开始计数
     * @count 数到几出列
     * @复杂度: O(mn)
     *
     */
    public void josephus(int total,int count){
        Node head = create(total);
        Node cNode = head;
        Node pNode = null;
        int start = 1;
        int index = start;
        int mm = 0 ;
        while(cNode.next != cNode){
//            while(total > 1){
            if(index == count){
                mm++;
                System.out.println("第"+mm+"个出列的是: "+cNode.data);
                if(count == start) {

                    pNode = cNode.next;
                    cNode = pNode;
                }else {
                    pNode.next = pNode.next.next;
                    cNode = cNode.next;
                }
                total--;
                index = start;
            }else {
                index++;
                pNode = cNode;
                cNode = cNode.next;
            }
        }
        System.out.println("最后个出列的是: "+cNode.data);
    }

    public Node create(int total){
        Node head = new Node(0);
        Node curr =  head;
        for(int i = 0 ;i< total-1 ; i++){
            Node p = new Node(i+1);
            curr.next = p;
            curr = p;
        }
        curr.next = head;
        return  head;
    }

    public static void main(String[] args) {
        Josephus josephus = new Josephus();
        josephus.josephus(10,8);
    }

 }
