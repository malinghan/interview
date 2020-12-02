package leetcode;

/**
 * @author : linghan.ma
 * @Package leetcode
 * @Description:
 * @date Date : 2020年12月02日 10:19 AM
 **/
public class L69Sqrt {
    
    public static void main(String[] args) {
//      System.out.println(new L69Sqrt().mySqrt(100));
        System.out.println(new L69Sqrt().mySqrt1(100));
        double e = 1e-1;
        System.out.println(e);
        System.out.println(1e-1);
    }
    
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ( mid   < x/mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    
    
        //    while (low <= high) {
        //        long mid = low + (high - low) / 2;
        //        long r = mid * mid;
        //        if (r > x) high = mid - 1;
        //        else if (r < x) low = mid + 1;
        //        else return (int) mid;
        //    }
        //return (int) low - 1;
    }
    
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
    
//    while (low <= high) {
//        long mid = low + (high - low) / 2;
//        long r = mid * mid;
//        if (r > x) high = mid - 1;
//        else if (r < x) low = mid + 1;
//        else return (int) mid;
//    }
//return (int) low - 1;
//
//while (low < high) {
//        long mid = low + (high - low) / 2;
//        long r = mid * mid;
//        if (r > x) high = mid;
//        else if (r < x) low = mid + 1;
//        else return (int) mid;
//    }
//return (int) low - 1;
//while (low < high) {
//        long mid = low + (high - low + 1) / 2;
//        long r = mid * mid;
//        if (r > x) high = mid - 1;
//        else if (r < x) low = mid;
//        else return (int) mid;
//    }
//return (int) low;
}
