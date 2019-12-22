package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月22日 1:50 PM
 **/
public class ComplexityAnalysis {

    // 全局变量，大小为10的数组array，长度len，下标i。
    int array[] = new int[10];
    int len = 10;
    int i = 0;


    /**
     * 数组扩容的算法
     * @param element
     */
    // 往数组中添加一个元素
    void add(int element) {
        if (i >= len) { // 数组空间不够了
            // 重新申请一个2倍大小的数组空间
            int new_array[] = new int[len*2];
            // 把原来array数组中的数据依次copy到new_array
            for (int j = 0; j < len; ++j) {
                new_array[j] = array[j];
            }
            // new_array复制给array，array现在大小就是2倍len了
            array = new_array;
            len = 2 * len;
        }
        // 将element放到下标为i的位置，下标i加一
        array[i] = element;
        ++i;
    }

    public static void main(String[] args) {


    }

}
