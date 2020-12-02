package leetcode;

import java.util.LinkedList;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description:
 * @date Date : 2020年12月02日 2:07 PM
 **/
public class L617MergeTwoTree {
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(5);
        node1.left.left = new TreeNode(4);
        node1.left.right = new TreeNode(2);
        node1.right.left = new TreeNode(7);
        node1.right.right = new TreeNode(6);
    
        TreeNode node2 = new TreeNode(3);
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(5);
        node2.left.left = new TreeNode(4);
        node2.left.right = new TreeNode(2);
        node2.right.left = new TreeNode(7);
        node2.right.right = new TreeNode(6);
        System.out.println(new L617MergeTwoTree().mergeTwoTree(node1,node2));
    }
    
    
    public TreeNode mergeTwoTree(TreeNode node1,TreeNode node2){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(node1);
        queue.addLast(node2);
        while(queue.size()>0){
            TreeNode val1 = queue.removeFirst();
            TreeNode val2 = queue.removeFirst();
            val1.val = val1.val+val2.val;
            if(val1.left != null && val2.left != null){
                queue.addLast(val1.left);
                queue.addLast(val2.left);
            }else if(val1.left == null){
                val1.left = val2.left;
            }
    
            if(val1.right != null && val2.right != null){
                queue.addLast(val1.right);
                queue.addLast(val2.right);
            }else if(val1.right == null){
                val1.right = val2.right;
            }
        }
        return node1;
    }
}
