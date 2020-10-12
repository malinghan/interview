package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package data.map
 * @Description:
 * @date Date : 2020年09月17日 11:46 PM
 **/
public class ThreeSum {
    /**
     * 使用双指针遍历的方式来进行
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        //先进行边界检查
        if( n < 3) {
            return new ArrayList<>();
        }
        //进行排序，这个是双指针的基础
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //进行双指针遍历
        for(int i = 0; i< n -2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = - nums[i];
            int j = i+1;
            int k = n - 1;
            while(j<k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> s = new ArrayList<>();
                    s.add(nums[i]);
                    s.add(nums[j]);
                    s.add(nums[k]);
                    res.add(s);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while ( k < n-1 && j<k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }else if(nums[j] + nums[k] < target){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {0,0,0};
        int[] nums = {-1, 0, 1, 2, -1, -2};
        System.out.println(ThreeSum.threeSum(nums));
    }
}