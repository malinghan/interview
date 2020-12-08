package ratelimit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : linghan.ma
 * @Package ratelimit
 * @Description:
 * @date Date : 2020年12月09日 12:19 AM
 **/
public class ConfineManager {
    // 定时线程
    private final ScheduledThreadPoolExecutor scheduledCheck = new ScheduledThreadPoolExecutor(2);
    // 执行补充线程池
    private final ExecutorService executorService = new ThreadPoolExecutor(5, 200,
            60L, TimeUnit.SECONDS, new SynchronousQueue<>(),
            new NamedThreadFactory("supplement",true));
    
    // 限流器容器
    private Map<String,RateLimiter> rateLimiterMap = new ConcurrentHashMap<>();
    
    @PostConstruct
    public void init(){
        scheduledCheck.scheduleAtFixedRate(new SupplementRateLimiter(), 1, 1, TimeUnit.SECONDS);
    }
    
    @PreDestroy
    public void destroy(){
        scheduledCheck.shutdown();
    }
    
    /**
     * 通过key获取相应的限流器
     */
    public void acquire(String key,int tokenCount){
        RateLimiter rateLimiter = rateLimiterMap.get(key);
        // 双检锁确保安全创建
        if(rateLimiter==null){
            synchronized (this){
                // init RateLimiter
                rateLimiter = rateLimiterMap.computeIfAbsent(key, k -> new RateLimiter(tokenCount));
            }
        }
        // 尝试获取令牌
        if(!rateLimiter.acquire()){
            // 获取失败，根据实际情况进行处理，这里直接抛异常了
//            Assert.throwBizException(ErrorCode.API_CONFINE_RATE_LIMITER);
        }
    }
    
    /**
     * 补充相应的令牌数
     */
    private class SupplementRateLimiter implements Runnable{
        @Override
        public void run(){
            rateLimiterMap.values().forEach(rateLimiter -> rateLimiter.supplement(executorService));
        }
    }
}
