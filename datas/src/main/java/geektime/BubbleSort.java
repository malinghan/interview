package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月25日 7:39 PM
 **/
public class BubbleSort {

    public static int[] bubbleSort(int[] array){
        for(int i = 0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                if(array[i] >= array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }

        }
        return array;
    }

    public static void main(String[] args) {
        int[] array  = {4,5,6,7,2,3,1};
        int[] res = bubbleSort(array);
        for(int i = 0 ;i<res.length;i++){
            System.out.println(array[i]);
        }
    }
}
