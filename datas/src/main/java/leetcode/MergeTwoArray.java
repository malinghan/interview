package leetcode;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description:
 * @date Date : 2020年12月02日 12:19 AM
 **/
public class MergeTwoArray {
    
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,0,0,0,0,0};
        int[] nums2 = {5,6,7,8,9};
        new MergeTwoArray().merge(nums1,5,nums2,nums2.length);
//        System.out.println(nums1);
        for (final int re : nums1) {
            System.out.print(re+",");
        }
    }
    
    
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        System.arraycopy(nums1, 0, res, 0, m);
        System.arraycopy(nums2, 0, res, m, n);
        System.out.println(res);
        nums1 = res;
        //        Arrays.sort(nums1);
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);
        int p1 = 0;
        int p2 = 0;
        
        int p = 0;
        
        while(p1 < m && p2 <n){
            nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++]:nums2[p2++];
        }
        
        if(p1 < m){
            System.arraycopy(nums1_copy,p1,nums1,p1+p2,m+n - p1 - p2);
        }
        
        if(p2 < n){
            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);
        }
    }
}
