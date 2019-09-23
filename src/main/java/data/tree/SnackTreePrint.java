package data.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
 *         /          /
 *        21          33
 *        \            \
 *          34          88
 *
 *  题目:
 *     要求打印格式如下：
 *      10
 *      13 6
 *      3 9 8 18
 *  核心要点:
 *
 **/
public class SnackTreePrint {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeft(new Node(6));
        root.setRight(new Node(13));
        root.getLeft().setLeft(new Node(3));
        root.getLeft().setRight(new Node(9));
        root.getLeft().getRight().setLeft(new Node(21));
        root.getLeft().getRight().getLeft().setRight(new Node(34));
        root.getRight().setLeft(new Node(8));
        root.getRight().setRight(new Node(18));
        root.getRight().getRight().setLeft(new Node(33));
        root.getRight().getRight().getLeft().setRight(new Node(88));
        binTreePrint(root);
    }

    /**
     * 问题：非递归算法
     * 解决方案：
     * 1. queue + stack  queue 先进先出 stack后进后出
     * 2. 2个指针 last 当前行的最右节点 nlast 下一行的最右节点 last.right = nlast   队列的尾部
     * 3. 循环换行条件：当遍历到了当前行的最右时，令 last = nlast nlast = last.right
     * 4. stack 奇数使用  queue 偶数使用
     * @param root
     */
    public static void  binTreePrint(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Node> stack = new Stack<Node>();
        int i = 0;
        queue.offer(root);
        while(true){
            if(i%2 == 0){
                while(!queue.isEmpty()) {
                    Node curr = queue.poll();
                    System.out.print(curr.getData() + "  ");
                    if (curr.getLeft() != null) {
                        stack.push(curr.getLeft());
                    }
                    if (curr.getRight() != null) {
                        stack.push(curr.getRight());
                    }
                    if(queue.isEmpty()){
                        i++;
                        System.out.println();
                    }
                }
            }else{
                while(!stack.isEmpty()) {
                    Node curr = stack.pop();
                    System.out.print(curr.getData() + "  ");
                    if (curr.getRight() != null) {
                        ((LinkedList<Node>) queue).addFirst(curr.getRight());
                    }
                    if (curr.getLeft() != null) {
                        ((LinkedList<Node>) queue).addFirst(curr.getLeft());
                    }
                    if(stack.isEmpty()){
                       i++;
                       System.out.println();
                    }
                }
            }
        }
    }

}
