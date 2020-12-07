package tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package tree
 * @Description:
 * @date Date : 2020年11月23日 3:13 PM
 *
 * 思路: 广度优先搜索
 *   每次遍历都把当前层的node，存储在队列，同时需要记录当前层的个数，由此判断是否需要进入到下一层
 *
 * init:
 *    list res
 *    queue
 *    queue.add(root)
 *    while(!queue empty)
 *       length = queue.size()
 *       while(i== length)
 *          root = queue.poll();
 *          res.add(root.val)
 *          queue.push(root.left)
 *          queue.push(root.right)
 **/
public class LevelOrderDemo {
    
    
    public static List<Integer> levelOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        //记录一个queue的size
        while(!queue.isEmpty()){
            //输出当前节点、并将下一个level的节点加入队列
            int length = queue.size();
            for (int i = 0; i < length; i++) {
            root = queue.poll();
                if(root != null) {
                    res.add(root.val);
                    queue.push(root.left);
                    queue.push(root.right);
                }
            }
        }
        return res;
    }
    
    public  static List<List<Integer>> levelOrder2(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }
        //用来存放最终结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(1,root,res);
        return res;
    }
    
    public  static  void  dfs(int index,TreeNode root, List<List<Integer>> res) {
        //假设res是[ [1],[2,3] ]， index是3，就再插入一个空list放到res中
        if(res.size()<index) {
            res.add(new ArrayList<Integer>());
        }
        //将当前节点的值加入到res中，index代表当前层，假设index是3，节点值是99
        //res是[ [1],[2,3] [4] ]，加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index-1).add(root.val);
        //递归的处理左子树，右子树，同时将层数index+1
        if(root.left!=null) {
            dfs(index+1, root.left, res);
        }
        if(root.right!=null) {
            dfs(index+1, root.right, res);
        }
    }
    
    
    /**
     *       6
     *     4   7
     *  3    5
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(levelOrder(root));
        System.out.println(levelOrder2(root));
    }
}
