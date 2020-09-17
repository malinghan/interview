package queue;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : linghan.ma
 * @Package queue
 * @Description:
 * @date Date : 2020年09月17日 3:31 PM
 **/
public class Solution {

    /**
     *
     * @param nums
     * @param k
     * @return
     *
     * 1.  deque.peek就是max的下标
     * 2.  deque存储的是下标
     * 3. 每添加一个元素，就进行如下清洗
     *    3.1 如果peek值在滑动窗口外，则remove
     *    3.2 否则，如果peek值小于新加的值，deque从尾部全部移出去，再插入新值
     *    3.3 如果peek值大于新加的值，deque从尾部部分移出去(没有出头之日)，再插入新增
     * 4. 3.2 3.3 可以合并
     * 5. i >= k-1时，开始存储结果
     *
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<Integer>();

        for(int i=0;i<nums.length;i++) {
            // 删除队列中小于窗口左边下标的元素
            if(i >= k && i - k + 1 > deque.peek()){
                deque.remove();
            }

            // 从队列右侧开始, 删除小于nums[i] 的元素
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }


            deque.add(i);

            // 队列左侧是最大值,加入结果
            if(i >= k-1){
                res[i - k + 1] = nums[deque.peek()];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] aaa = {1,2,4,7,3,5};
        Solution maxSlickWindow = new Solution();
        int[] res =  maxSlickWindow.maxSlidingWindow(aaa, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
