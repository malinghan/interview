package tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package tree
 * @Description:
 * @date Date : 2020年11月23日 3:13 PM
 **/
public class PostOrderDemo {
    
    /**
     * 递归遍历：根，右，左
     * @param root
     * @return
     */
    public static List<Integer> postOrder(TreeNode root){
        //定义res
        List<Integer> res = new ArrayList<>();
        if(root != null){
            res.add(root.val);
            res.addAll(postOrder(root.right));
            res.addAll(postOrder(root.left));
        }
        return res;
    }
    
    public static List<Integer> postOrder2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack  = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            if(root != null){
                res.add(root.val);
                stack.push(root.left);
                stack.push(root.right);
            }
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
        System.out.println(postOrder(root));
        System.out.println(postOrder2(root));
    }
}
