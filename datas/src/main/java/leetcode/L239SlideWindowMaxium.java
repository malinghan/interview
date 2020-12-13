package leetcode;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description:
 * @date Date : 2020年12月13日 6:13 PM
 **/

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * 239. 滑动窗口最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *
 */
public class L239SlideWindowMaxium {
    
    public static void main(String[] args) {
        int[] res= {1,3,-1,-3,5,3,6,7};
         int[] asdsa = new L239SlideWindowMaxium().maxSlidingWindow1(res, 3);
        for (int i = 0; i < asdsa.length; i++) {
            System.out.println(asdsa[i]);
        }
    }
    
    
    //大顶堆
    public int[] maxSlidingWindow(int[] nums, int k) {
        //k 大顶堆
        //1. 定义一个大顶堆
        //2. 每次add的时候都remove old，然后取top
        int[] res = new int[nums.length-k];
        // a 入队
        // b 出队
//     queue.add()
        return null;
    }
    
    //优先级队列
    
    /**
     *  1 2 -1 -3 3 5 -1
     * [     2]
     *           [      5]
     *
     *   //从前往后删
     *   [i-k+1    i]
     *   deque.peek()
     *
     *
     *   removeFirst()
     *
     *   //从后往前删除比新元素小的
     *   while(!deque.isEmpty() && nums[deque.last] < nums[i]){
     *       removeLast();
     *   }
     *
     *   addLast()
     *
     *   i - k + 1 >= 0
     * @param nums
     * @param k
     * @return
     */
    public  int[] maxSlidingWindow1(int[] nums , int k){
        
        if(nums.length == 0){
            return new int[0];
        }
        
        //结果
        int[] res = new int[nums.length - k + 1];
        
        Deque<Integer> deque = new ArrayDeque<>();
    
        for(int i=0;i<nums.length;i++) {
            
            if(i < k){
            
            }
            // 删除队列中小于窗口左边下标的元素
            if(i >= k && i - k + 1 > deque.peek()) {
                //deque.removeFirst();
                deque.remove();
            }
        
            // 从队列右侧开始, 删除小于nums[i] 的元素
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            
            deque.add(i);
        
            // 队列左侧是最大值,加入结果
            if(i - k + 1 >= 0)
                res[i - k + 1] = nums[deque.peek()];
        }
        return res;
    }
    
}
