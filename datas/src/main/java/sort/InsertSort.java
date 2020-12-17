package sort;

/**
 * @author : linghan.ma
 * @Package sort
 * @Description:
 * @date Date : 2020年12月15日 8:26 PM
 **/
public class InsertSort {
    
    public static void main(String[] args) {
        // i,i++
        // 1,4,5,3,2
        //
        int[] res = {1,5,4,3,2};
        new InsertSort().insertSort(res);
        for(int i = 0 ; i <res.length;i++){
            System.out.print(res[i]);
        }
    }
    
    
    public void insertSort(int[] arr){
        int n = arr.length;
        for(int i =1;i< n;i++){
            if( arr[i] < arr[i-1]){
                int j = i-1;
                int temp = arr[i];
                //swap
                while( j >= 0 && temp < arr[j]){
                    int temp1 = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j]  = temp1;
                    j--;
                }
            }
        }
    }
    
    public void insertSort1(int[] arr){
        int n = arr.length;
        for(int i =1;i< n;i++){
            if( arr[i] < arr[i-1]){
                int j = i-1;
                int temp = arr[i];
                //copy
                while( j >= 0 && temp < arr[j]){
                    arr[j+1] = arr[j];
                    j--;
                }
                arr[j] = temp;
            }
        }
    }
}
