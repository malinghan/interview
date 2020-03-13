package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月25日 7:47 PM
 **/
public class InsertSort {
    public static int[] insertSort(int[] array){
        int tmp = 0;
        for(int i = 1;i<array.length;i++){
            if(array[i] < array[i-1]){
                tmp = array[i];
                for(int j = i;j>=0;j--){
                    if(j>0 && tmp < array[j-1]){
                        array[j] = array[j-1];
                    }else {
                        array[j]  = tmp;
                    }
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array  = {4,5,6,7,2,3,1};
        int[] res = insertSort(array);
        for(int i = 0 ;i<res.length;i++){
            System.out.println(array[i]);
        }
    }
}
