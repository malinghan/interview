package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月22日 1:50 PM
 *
 *
 * 最好的时间复杂度:  O(1)
 * 最坏的时间复杂度:  O(n)
 * 平均的时间复杂度: O(1)
 * 均摊的时间复杂度: O(1)
 *
 * 当i < len时, 即 i = 0,1,2,...,n-1的时候，for循环不走，所以这n次的时间复杂度都是O(1);
 * 当i >= len时, 即 i = n的时候，for循环进行数组的copy，所以只有这1次的时间复杂度是O(n);
 * 由此可知:
 * 该算法的最好情况时间复杂度(best case time complexity)为O(1);
 * 最坏情况时间复杂度(worst case time complexity)为O(n);
 * 平均情况时间复杂度(average case time complexity),
 * 第一种计算方式: (1+1+...+1+n)/(n+1) = 2n/(n+1) 【注: 式子中1+1+...+1中有n个1】,所以平均复杂度为O(1);
 * 第二种计算方式(加权平均法，又称期望): 1*(1/n+1)+1*(1/n+1)+...+1*(1/n+1)+n*(1/(n+1))=1，所以加权平均时间复杂度为O(1);
 * 第三种计算方式(均摊时间复杂度): 前n个操作复杂度都是O(1)，第n+1次操作的复杂度是O(n)，所以把最后一次的复杂度分摊到前n次上，那么均摊下来每次操作的复杂度为O(1)
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

}
