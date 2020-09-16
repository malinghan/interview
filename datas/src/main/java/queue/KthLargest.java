package queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author : linghan.ma
 * @Package queue
 * @Description:
 * @date Date : 2020年09月17日 1:11 AM
 **/
public class KthLargest {
    /**
     * 方法1: 优先队列
     * 维护一个length为k的优先队列
     java中数据结构为
     */
    public PriorityBlockingQueue<Integer> queue;
    //记录第k大的数
    Integer value = 0;

    public KthLargest(int k, int[] nums) {
        value = k;
        queue  = new PriorityBlockingQueue<Integer>(k);
        for(int i = 0 ;i < nums.length;i++){
           add(nums[i]);
        }
    }

    //最小堆 队列头部是最小的? 保证它是第k大的? 其他的都比他大，那么其他的都是这个数据流里面的老东西，当add的时候，判断一下这个值是不是比peek小，则不管
    public int add(int val) {
        //如果mums.length <= k
        if(queue.size() <= value){
            queue.add(val);
            return 0;
        }else {
            //这个值比value大,插入这个值，取peek return
            if (queue.peek() > val) {
                return queue.peek();
            } else {
                queue.poll();
                queue.add(val);
                return queue.peek();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,5,8,2};
         KthLargest obj = new KthLargest(3, nums);
        int param_1 = obj.add(3);
        System.out.println(param_1);

        int param_2 = obj.add(5);
        System.out.println(param_2);

        int param_3 = obj.add(10);
        System.out.println(param_3);

        int param_4 = obj.add(9);
        System.out.println(param_4);

        int param_5 = obj.add(4);
        System.out.println(param_5);

        int param_6 = obj.add(12);
        System.out.println(param_6);

        int param_7 = obj.add(13);
        System.out.println(param_7);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */