package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description:
 * @date Date : 2020年09月27日 10:36 PM
 **/
public class IsValidBST1 {

    /**
     * 中序遍历，数组存储，排序，比对排序后的数组和排序前的是否一致
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root){
        List<Integer> res =  inOrder(root,new ArrayList<>());
        TreeSet set = new TreeSet<>(res);
         if(new ArrayList<>(set).equals( res)){
             return true;
         }
          return false;
    }

    public static List<Integer> inOrder(TreeNode root,List<Integer> res){
        if(root == null){
            return new ArrayList<>();
        }
        if(root.left != null) {
              inOrder(root.left,res);
        }
        res.add(root.val);
        if(root.right != null) {
              inOrder(root.right,res);
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(inOrder(root,new ArrayList<>()));;
        System.out.println(isValidBST(root));
    }
}
