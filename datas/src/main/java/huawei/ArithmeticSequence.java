package huawei;

import java.util.Scanner;

/**
 * @author : linghan.ma
 * @Package huawei
 * @Description: 等差数列
 * @date Date : 2020年10月28日 10:55 PM
 **/
public class ArithmeticSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int n = scanner.nextInt();
            System.out.println(cal(n));
        }
    }

    /**
     * 求和公式法
     * @param n
     * @return
     */
    public static int cal(int n){
        return (1  + (n * 3)) * n /2;
    }
}
