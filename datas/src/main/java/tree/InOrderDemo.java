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
