package huawei;

import java.util.*;

/**
 * @author : linghan.ma
 * @Package huawei
 * @Description: 最长的数字串
 * @date Date : 2020年10月28日 11:05 PM
 **/
public class FindLongestString92s02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        if(nextLine == null || nextLine.length() == 0){
            System.out.print("");
            return;
        }
        //准备一个array存储最大数字串的开始的下标
        List<Integer> arrayList = new ArrayList<>();
        int tempMaxLen = 0;
        Set<String> numbers = new HashSet<>();
        for(int n = 0 ; n<10;n++){
            numbers.add(n+"");
        }
        String[] strs = nextLine.split("");
        for(int i = 0 ; i < strs.length; i++){
            if(numbers.contains(strs[i])){
                int tempIndex = i;
                int tempLen = 0;
                while(numbers.contains(strs[i])){
                    tempLen ++;
                    if(i == strs.length-1){
                        break;
                    }else {
                        i++;
                    }
                }
                if(tempLen > tempMaxLen){
                    tempMaxLen = tempLen;
                    arrayList.clear();
                    arrayList.add(tempIndex);
                }else if(tempLen == tempMaxLen){
                    arrayList.add(tempIndex);
                }
            }
        }

        StringBuilder sb = new StringBuilder("");
        for(Integer in: arrayList){
            sb.append(nextLine.substring(in,in+tempMaxLen));
        }
        sb.append(",");
        sb.append(tempMaxLen);
        System.out.println(sb.toString());

    }

}
