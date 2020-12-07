package tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package tree
 * @Description:
 * @date Date : 2020年11月23日 10:45 AM
 *
 * 思路:
 *   中序遍历：左-根-右
 *   每次迭代，先向左迭代,使用栈记录所有的左节点
 *   如果发现当前节点为空,弹栈，放入结果列表, 将当前节点改为弹栈的节点(向上回溯),并将当前节点指向右边节点[这个过程就是局部的左中右]
 *   然后继续
 * 实现:
 * init:
 *     list<Integer> //存放结果
 *     stack<TreeNode> //用于迭代时存放中间值
 * while(!top || stack not empty)
 *     if(!top)
 *          stack.push(top)
 *          top = top.left
 *     else
 *         list.add(stack.pop().val)
 *         top = top.right
 * return list;
 **/
public class InOrderDemo {
    
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root == null) {
            return new ArrayList<>();
        }
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }
    
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode top = root;
        while(top != null || !stack.isEmpty()){
            if (top != null){
                stack.push(top);
                top = top.left;
            }else {
                top = stack.pop();
                list.add(top.val);
                top = top.right;
            }
        }
        return list;
    }
    
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(inorderTraversal(root));
        System.out.println(inorderTraversal2(root));
    }

    
}
