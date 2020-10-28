package huawei;

import java.util.Scanner;

/**
 * @author : linghan.ma
 * @Package huawei
 * @Description:
 * @date Date : 2020年10月28日 9:44 PM
 **/
public class WordCount02 {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String s = scanner.nextLine();
        String c = scanner.nextLine();
        System.out.println(wordCount(s,c));
    }

    //word count
    public static  int wordCount(String str,String c){
        String[] strs = str.split("");
        int count = 0;
        for(String s :  strs){
            if(s.equalsIgnoreCase(c)){
                count++;
            }
        }
        return count;
    }
}

/**
 * 考察:
 *   将一个字符串拆分成单个字符的字符串数组 `String[] string.split("")`
 *    stringA.equalsIgnoreCase(stringA)
 */
