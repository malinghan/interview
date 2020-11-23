package leetcode;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description:
 * @date Date : 2020年11月23日 11:24 AM
 **/
public class IsValidBST3 {
    
    static long pre =  Long.MIN_VALUE;
    
    public static boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
           return false;
        }
        if(root.val <= pre){
            return false;
        }
        pre = root.val;
        //访问右子树
        return isValidBST(root.right);
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
    }
}
