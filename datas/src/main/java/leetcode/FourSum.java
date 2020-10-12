package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description:
 * @date Date : 2020年09月18日 1:37 AM
 **/
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        //先进行边界检查
        if( n < 4) {
            return new ArrayList<>();
        }
        //进行排序，这个是双指针的基础
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //进行双指针遍历
        for(int i = 0; i< n -3; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int m = i+1; m< n -2; m++) {
                if(m > i+1 && nums[m] == nums[m-1]){
                    continue;
                }
                int t = target - nums[i] - nums[m];
                int j = m + 1;
                int k = n - 1;
                while (j < k) {
                    if (nums[j] + nums[k] == t) {
                        List<Integer> s = new ArrayList<>();
                        s.add(nums[i]);
                        s.add(nums[m]);
                        s.add(nums[j]);
                        s.add(nums[k]);
                        res.add(s);
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        while (k < n - 1 && j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    } else if (nums[j] + nums[k] < t) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        int[] nums = {0,0,0};
        //{-2.-1,0,0,1,2}
        int[] nums = {-1,0,1,2,-1,-4};
        //-4  -1 -1 0 1 2
        System.out.println(FourSum.fourSum(nums,-1));
    }
}
