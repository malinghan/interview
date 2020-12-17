package sort;

/**
 * @author : linghan.ma
 * @Package sort
 * @Description:
 * @date Date : 2020年12月17日 3:17 PM
 **/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {
    
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        
        public TreeNode(int val){
            this.val = val;
        }
    }
    
    //1、蛇形遍历打印二叉树
    public static void main(String[] args) {
        System.out.println("Hello World!");
        TreeNode root = new TreeNode(1);
        List<List<Integer>> res = new Main().snackPrint(root);
        for(List<Integer> list:res){
            for(Integer val:list){
                System.out.print(val+" ");
            }
            System.out.println("");
        }
    }
    
    // init:
    // level
    //queue
    //stack
    public List<List<Integer>> snackPrint(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue =new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for(int i = 0; i< n;i++){
                TreeNode node = queue.poll();
                if(level %2 == 0){
                    list.add(node.val);
                }else{
                    stack.push(node.val);
                }
                if(node.left != null){
                    queue.offer(node.left);
                    n++;
                }
                if(node.right != null){
                    queue.offer(node.right);
                    n++;
                }
            }
            if(level %2 == 1){
                List<Integer> list1 = new ArrayList<>();
                while(!stack.isEmpty()){
                    list1.add(stack.pop());
                }
                res.add(list1);
            }else{
                res.add(list);
            }
            level++;
        }
        return res;
    }
}