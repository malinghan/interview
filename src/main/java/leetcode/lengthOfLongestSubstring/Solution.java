package leetcode.lengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author : linghan.ma
 * @Package leetcode.lengthOfLongestSubstring
 * @Description: 3
 * @date Date : 2019年09月20日 2:26 AM
 **/
public class Solution {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstringHashSet(s));
        System.out.println(lengthOfLongestSubstringHashSet("bbbbb"));
        System.out.println(lengthOfLongestSubstringHashSet("pwwkew"));
    }

    /**
     * 暴力破解
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){
       char [] chars  = s.toCharArray();
       ArrayList arrayList = new ArrayList();
        ArrayList oldArrayList = new ArrayList();
       for(int i = 0;i<chars.length;i++){
           for(int j=i;j<chars.length;j++){
               if(arrayList.contains(chars[j]+"")){
                   break;
               }
               arrayList.add(chars[j]+"");
           }
           if(oldArrayList.size() < arrayList.size()){
               oldArrayList =(ArrayList) arrayList.clone();
           }
           arrayList.clear();
       }
        System.out.println(oldArrayList.toString());
       return oldArrayList.size();
    }

    /**
     * hashSet 滑动窗口
     * 处理好窗口的边界就可以了
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringHashSet(String s){
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        for(int i = 0;i<n;i++){
               for(int j = i ;j<n;j++) {
                   if (!set.contains(s.charAt(j))) {
                       set.add(s.charAt(j));
                   } else {
                       set.remove(s.charAt(i));
                       set.remove(s.charAt(j));
                       break;
                   }
               }
            }
        System.out.println(set.toString());
        return set.size();
    }


}
