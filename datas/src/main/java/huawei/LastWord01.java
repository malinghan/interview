package huawei;

/**
 * @author : linghan.ma
 * @Package huawei
 * @Description:
 * @date Date : 2020年10月28日 4:56 PM
 **/
public class LastWord01 {

    public  int lastWord(String s){
        int count = 0;
        if(s == null || s.length() == 0){
            return 0;
        }
        // 查询最后一个单词的长度
        String[] arr = s.split(" ");
        count = arr[arr.length-1].length();
        return count;
    }

    public static void main(String args[]){
//        String s = "hello nowcoder";
        String s = null;
        System.out.println(new LastWord01().lastWord(s));
    }

}
