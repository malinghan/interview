package geektime;

import java.util.Arrays;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月26日 3:19 PM
 **/
public class ShellSort1 {
    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     * @param arr
     */
    public static void sort1(int []arr){
        //增量gap，并逐步缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0 && temp<arr[j-gap]){
                        //移动法
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String []args){
        int []arr1 ={1,4,2,7,9,8,3,6};
        sort1(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
