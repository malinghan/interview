package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description: 在中序遍历的过程中比对当前节点和上一个节点的大小
 * @date Date : 2020年09月27日 11:19 PM
 **/
public class IsValidBST2 {
   static List<Integer> res = new ArrayList<>();

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // inorder: root前面的数
        // if inorder >= root 说明不是一个bst
        double inorder = -Integer.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
                if (inorder == -Integer.MAX_VALUE && stack.isEmpty()) {
                    return true;
                }
                if (root.val <= inorder) {
                    return false;
                }
                inorder = root.val;
                res.add(root.val);
                root = root.right;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

//        TreeNode root = new TreeNode(-2147483648);

//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(7);
//        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));
        System.out.println(res);
    }


}
