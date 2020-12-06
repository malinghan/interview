package leetcode;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description: 二叉搜索树的lca问题
 * @link https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * @date Date : 2020年12月06日 12:50 PM
 **/

/**
 *     1. 分析题意:
 *              二叉搜索树: left < parent < right
 *              find common node
 *     3. 初始化:
 *          node = root
 *     4. 条件判断:
 *            while(true)
 *               if(node == null || node == p || node == q){
 *                     return node;
 *               }else if(node < p && node < q)
 *                          then node = node.right
 *               else if(node > p && node > q)
 *                          then node = node.left
 *               else
 *                  return node;
 */
public class L235BSTLAC {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(root == null || root.val == p.val || root.val == q.val){
                return root;
            }else if((root.val < p.val) && (root.val < q.val)){
                root = root.right;
            }else if((root.val > p.val) && (root.val  > q.val)){
                root = root.left;
            }else{
                return root;
            }
        }
    }
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(new L235BSTLAC().
                lowestCommonAncestor(root,root.left,root.left.right).val);
    }
    
}
