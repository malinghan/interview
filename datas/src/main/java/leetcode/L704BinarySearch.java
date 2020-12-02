package leetcode;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description:
 * @date Date : 2020年12月02日 1:08 AM
 **/
public class L704BinarySearch {
    
    public static void main(String[] args) {
//        int[] nums = {-1,0,3,5,9,12};
        int[] nums = {2,5};
        int target = 5;
        System.out.println(new L704BinarySearch().search(nums,target));
    }
    
    public int search(int[] nums, int target) {
        int left = 0;
        int right  = nums.length;
        while(left <= right ){
            int middle = left + (right -left)/2;
            if(nums[middle] < target){
                left = middle+1;
            }else if(nums[middle] > target){
                right = middle-1;
            }else{
                return middle;
            }
        }
        return -1;
    }
    
}
