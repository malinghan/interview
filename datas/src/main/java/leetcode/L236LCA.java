package leetcode;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description: 二叉树的最近公共祖先
 * @link https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @date Date : 2020年10月12日 2:01 AM
 **/

/**
 *
 */
public class L236LCA {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q) return root;
        TreeNode lson = lowestCommonAncestor(root.left,p,q);
        TreeNode rson = lowestCommonAncestor(root.right,p,q);

        if(lson == null && rson == null) {
          return null;
        }

        if(lson == null){
           return rson;
        }

        if(rson == null){
            return lson;
        }
//        if(left != null and right != null)
        return root;
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
