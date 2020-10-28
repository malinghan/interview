package huawei;

import java.util.*;

/**
 * @author : linghan.ma
 * @Package huawei
 * @Description: 最长的数字串
 * @date Date : 2020年10月28日 11:05 PM
 **/
public class FindLongestString92 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> set = new HashSet<>();
        for(int i = 0;i<10;i++){
            set.add(i+"");
        }
        String[] strs = input.split("");
        List<Integer> indexList = new ArrayList<>();
        int tempMaxLen = 0;
        for (int j = 0 ; j< strs.length; j++) {
            int tempLen = 0;
            int tempStart = j;
            while (set.contains(strs[j])){
                tempLen ++;
                if(j == strs.length -1){
                    break;
                }
                j++;
            }
            if(tempMaxLen < tempLen){
                tempMaxLen = tempLen;
                indexList.clear();
                indexList.add(tempStart);
            }else if(tempMaxLen == tempLen){
                indexList.add(tempStart);
            }
        }



        for (Integer integer : indexList) {
            System.out.print(input.substring(integer,integer+tempMaxLen)+",");
        }
        System.out.print(tempMaxLen);

        //map number count
    }

}
