package leetcode;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description: 二叉树的最近公共祖先
 * @date Date : 2020年10月12日 2:01 AM
 **/
public class LCA3 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //非递归的方式
        while(root != null){
            //判断两个值是否都小于根节点
            if(p.val < root.val && q.val < root.val){
                //直接排查左节点
                root = root.left;
            }
            //判断两个值是否都大于右节点
            else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        System.out.println(lowestCommonAncestor(root,root.left.right,root.right.left).val);
    }
}
