package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description:
 * @date Date : 2020年11月23日 5:35 PM
 **/
public class L199RightSideView {
    
    public List<Integer> rightSideView(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int length  = queue.size();
            TreeNode r = null;
            for(int i = 0 ; i< length; i++){
                root = queue.removeFirst();
                if(root != null){
                    r = root;
                }
                if(root.left != null){
                    queue.addLast(root.left);
                }
                if(root.right != null){
                    queue.addLast(root.right);
                }
            }
            if(r != null){
                res.add(r.val);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        TreeNode root = null;
        new L199RightSideView().rightSideView(root);
    }
}
