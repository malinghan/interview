package sort;

/**
 * @author : linghan.ma
 * @Package sort
 * @Description:
 * @date Date : 2020年12月16日 8:19 AM
 **/
public class MergeSort_2 {
    
    public void mergeSort(){
    
    }
    
    private void sort(int[] arr,int l,int r){
        if(l < r) {
            int mid = (l + r) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr,l,mid,r);
        }
    }
    
    private void merge(int[] arr,int l,int m,int r){
          //arr l m  r
          //复制
          int n1 = m - l +1;
          int n2 = r - m;
          int[] L = new int[n1];
          int[] R = new int[n2];
          //合并2个有序数组
          for(int i = 0;i < n1 ; i++){
              L[i] = arr[l+i];
          }
          
          for(int j = 0;j < n2 ; j++){
              R[j] = arr[m+1+j];
          }
          
          int i = 0;
          int j = 0;
          int k = l;
          while(i < n1 && j < n2){
              if(L[i] <= R[j]){
                  arr[k] = L[i];
                  i++;
              }else{
                  arr[k] = R[j];
                  j++;
              }
              k++;
          }
          
          while(i < n1){
              arr[k] = L[i];
              i++;
              k++;
          }
    
    
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
        
    }
    
    
    // Driver code
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Given Array");
        
        printArray(arr);
    
        MergeSort_2 ob = new MergeSort_2();
        
        ob.sort(arr, 0, arr.length - 1);
        
        System.out.println("\nSorted array");
        
        printArray(arr);
    }
    
    /* A utility function to print array of size n */
    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
    
   
}
