package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description: 是否是有效的BST
 * @date Date : 2020年09月27日 10:36 PM
 **/
public class IsValidBST1 {

    /**
     * 中序遍历，数组存储，排序，比对排序后的数组和排序前的是否一致
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root){
        List<Integer> res =  inOrder(root);
        List<Integer> sorted = res.stream().sorted().collect(Collectors.toList());
        return sorted.equals(res);
    }

    public static List<Integer> inOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        res.addAll(inOrder(root.left));
        res.add(root.val);
        res.addAll(inOrder(root.right));
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(inOrder(root));;
        System.out.println(isValidBST(root));
    }
}
