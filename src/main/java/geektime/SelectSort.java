package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月25日 8:07 PM
 **/
public class SelectSort {
    public static int[] selectSort(int[] array){
        for(int i = 0;i<array.length;i++){
            int min = array[i];
            int index = i;
            for(int j = i+1;j<array.length;j++){
                if(array[j]<min){
                    min = array[j];
                    index = j;
                }
            }
            if(index != i) {
                int tmp = array[index];
                array[index] = array[i];
                array[i] = tmp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array  = {4,5,6,7,2,3,1};
        int[] res = selectSort(array);
        for(int i = 0 ;i<res.length;i++){
            System.out.println(array[i]);
        }
    }
}
