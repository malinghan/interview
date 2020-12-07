package tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package tree
 * @Description:
 * @date Date : 2020年11月23日 2:42 PM
 **/

/**
 * init:
 *  list
 *  stack
 * while(node != null !stack.isEmpty())
 *
 *   if (node != null)
 *       list.add(node.val)
 *       stack.push(node)
 *       node = node.left;
 *   else
 *      node = stack.pop();
 *      node = node.right();
 *
 */
public class PreOrderDemo {
    
    
    public static List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root!= null || !stack.isEmpty()){
            if(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                root = root.right;
            }
            
        }
        return res;
    }
    
    public static List<Integer> preOrder2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root != null){
            res.add(root.val);
            res.addAll(preOrder2(root.left));
            res.addAll(preOrder2(root.right));
        }
        return res;
    }
    
    /**
     *       6
     *     4   7
     *  3    5
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(preOrder(root));
//        System.out.println(preOrder2(root));
    }
}
