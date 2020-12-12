package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description:
 * @date Date : 2020年12月12日 5:38 PM
 **/
public class L649DotaParty {
    
    public static void main(String[] args) {
        System.out.println(new L649DotaParty().predictPartyVictory("RDRDRRDDRDDD"));
    }
    
    /**
     * RDRDRRDDRDDD
     *
     * R R RR  R
     *  D D  DD DDD
     *               R  R  RR R
     *                         DDD
     *                             R R R
     */
    public String predictPartyVictory(String senate) {
        Queue<Integer> qr = new LinkedList<Integer>();
        Queue<Integer> qd = new LinkedList<Integer>();
        int n = senate.length();
        for(int i = 0; i < n;i++){
            if(senate.charAt(i) =='R'){
                qr.add(i);
            }else{
                qd.add(i);
            }
        }
        while(!qr.isEmpty() && !qd.isEmpty()){
            int r = qr.poll();
            int d = qd.poll();
            if(r < d){
                qr.offer(r+n);
            }else{
                qd.offer(d+n);
            }
        }
        return qr.isEmpty()? "Dire":"Radiant";
    }
}
