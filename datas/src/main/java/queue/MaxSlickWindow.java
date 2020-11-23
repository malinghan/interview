package queue;


import java.util.ArrayDeque;

/**
 * @author : linghan.ma
 * @Package queue
 * @Description:
 * @date Date : 2020年09月17日 3:32 AM
 **/
class MaxSlickWindow {

    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public  int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            deq.removeLast();
    }


    public static void main(String[] args) {
        int[] aaa = {1,2,4,7,3,5};
        MaxSlickWindow maxSlickWindow = new MaxSlickWindow();
        int[] res =  maxSlickWindow.maxSlidingWindow(aaa, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}

