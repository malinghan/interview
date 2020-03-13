package geektime;

/**
 * @author : linghan.ma
 * @Package geektime
 * @Description:
 * @date Date : 2019年12月23日 7:38 PM
 **/
public class Josephus1 {
    /**
     * @param n total
     * @param m count
     * @return
     */
    public int josephus(int n,int m) {
        if (1 == n) {
            return 0;
        }
        return (josephus(n - 1, m) + m) % n;
    }

    public int josephus1(int n,int m) {
            int res = m % n;
            for(int i = 2;i < n; i++){
                res = ( res + m ) % (n -1);
            }
            return res;
        }

    public static void main(String[] args) {
        Josephus1 josephus1 = new Josephus1();
        System.out.println(josephus1.josephus1(10,8));
    }
}
