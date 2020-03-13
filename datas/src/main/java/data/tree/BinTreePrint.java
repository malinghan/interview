package data.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : linghan.ma
 * @Package data
 * @Description: 层序遍历二叉树
 * @date Date : 2019年09月12日 2:47 AM
 *
 *  *        10
 *  *      /     \
 *  *    6         13
 *  *   / \       /  \
 *  *  3   9     8    18
 *
 *  题目:
 *     要求打印格式如下：
 *      10
 *      6 13
 *      3 9 8 18
 *  核心要点:
 *
 **/
public class BinTreePrint {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeft(new Node(6));
        root.setRight(new Node(13));
        root.getLeft().setLeft(new Node(3));
        root.getLeft().setRight(new Node(9));
        root.getRight().setLeft(new Node(8));
        root.getRight().setRight(new Node(18));
        binTreePrint(root);
    }

    /**
     * 问题：非递归算法
     * 解决方案：
     * 1. queue 存储整层的节点
     * 2. 2个指针 last 当前行的最右节点 nlast 下一行的最右节点 last.right = nlast   队列的尾部
     * 3. 循环换行条件：当遍历到了当前行的最右时，令 last = nlast nlast = last.right
     * @param root
     */
    public static void  binTreePrint(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        Node nlast = ((LinkedList<Node>) queue).getLast(); ;
        int i = 0;
        while(!queue.isEmpty()){
            Node curr =  queue.poll();
            System.out.print(i + ":");
            System.out.print(curr.getData()+"  ");
            if(curr.getLeft() != null) {
                queue.offer(curr.getLeft());
            }
            if(curr.getRight()!=null) {
                queue.offer(curr.getRight());
            }
            if(curr == nlast){
                if(!queue.isEmpty()) {
                    nlast = ((LinkedList<Node>) queue).getLast();
                    i++;
                    System.out.println();
                }
            }
        }
    }

}
