package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月23日 5:57 PM
 **/
public class Josephus2 {
    /**
     * @total 总人数
     * @from 从第几个人开始计数
     * @count 数到几出列
     * @复杂度: O(mn)
     */
    public void josephus(int total, int count) {
        int[] array = new int[total];
        int outCnt = 0; //出列的人数
        int numOff = 0; // 报数
        //染成1
        for (int i = 0; i < total ;i++) {
            array[i] = 1;
        }
        while (outCnt < total - 1) {
            for (int m = 0 ; m < total; m ++) {
                if (1 == array[m]) {
                    numOff++;
                    if(numOff == count){
                        System.out.println("第"+(outCnt+1)+"个出列的是: "+m);
                        outCnt++;
                        array[m] = 0;    // 已出列的人标记为0
                        numOff = 0;     // 从头开始报数
                    }
                }

            }
        }
        System.out.println(array.length);
        for (int j = 0; j < array.length ; j++) {
            if (1 == array[j]) {
                System.out.println("最后一个出列的是: "+ j);
            }
        }
    }

    public static void main(String[] args) {
        Josephus2 josephus = new Josephus2();
        josephus.josephus(10, 11);
    }
}
