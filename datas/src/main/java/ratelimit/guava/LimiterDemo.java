package ratelimit.guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author : linghan.ma
 * @Package ratelimit.guava
 * @Description:
 * @date Date : 2020年12月10日 1:31 PM
 **/
public class LimiterDemo {
    
    public static void main(String[] args) {
        new LimiterDemo().testAcquire();
    }
    
    /**
     *
     * RateLimiter.create(1) --->
     * public static RateLimiter create(double permitsPerSecond) {
     *     return create(permitsPerSecond, SleepingStopwatch.createFromSystemTimer());
     *   }
     *
     *  //平滑突发限流器
     *   static RateLimiter create(double permitsPerSecond, SleepingStopwatch stopwatch) {
     *     RateLimiter rateLimiter = new SmoothBursty(stopwatch, 1.0 /* maxBurstSeconds );
     *  rateLimiter.setRate(permitsPerSecond);
     *return rateLimiter;
     *
}
     */
    public void testAcquire() {
      RateLimiter limiter = RateLimiter.create(1);
        
        for(int i = 1; i < 10; i = i + 2 ) {
            double waitTime = limiter.acquire(i);
            System.out.println("cutTime=" + System.currentTimeMillis() + " acq:" + i + " waitTime:" + waitTime);
        }
    }
}
