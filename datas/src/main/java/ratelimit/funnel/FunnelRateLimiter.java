package ratelimit.funnel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : linghan.ma
 * @Package ratelimit.funnel
 * @Description:
 * @date Date : 2020年12月10日 1:06 PM
 *
 * 漏斗的剩余空间就代表着当前行为可以持续进行的数量，
 * 漏嘴的流水速率代表着系统允许该行为的最大频率。
 *
 * 如果漏嘴流水的速率大于灌水的速率，那么漏斗永远都装不满。
 * 如果漏嘴流水速率小于灌水的速率，那么一旦漏斗满了，灌水就需要暂停并等待漏斗腾空。
 *
 * 优点：
 * 1. 控制了容量的释放速率
 * 2. 以时间
 *
 * 确定:
 * 2. 没有控制
 **/
public class FunnelRateLimiter {
    
    static class Funnel {
        //漏斗初始化的容量和最大的容量
        int capacity;
        //每秒释放的速率
        float leakingRate;
        //还剩余的调用量
        int leftQuota;
        //上次漏水的时间
        long leakingTs;
        
        public Funnel(int capacity, float leakingRate) {
            this.capacity = capacity;
            this.leakingRate = leakingRate;
            this.leftQuota = capacity;
            this.leakingTs = System.currentTimeMillis();
        }
    
        /**
         * unnel 对象的 make_space 方法是漏斗算法的核心，
         * 其在每次灌水前都会被调用以触发漏水，给漏斗腾出空间来。
         * 能腾出多少空间取决于过去了多久以及流水的速率。
         * Funnel 对象占据的空间大小不再和行为的频率成正比，它的空间占用是一个常量。
         */
        void makeSpace() {
            //当前时间
            long nowTs = System.currentTimeMillis();
            //距离上次漏水时间的间隔
            long deltaTs = nowTs - leakingTs;
            //腾出的空间
            int deltaQuota = (int) (deltaTs * leakingRate);
            // 间隔时间太长，整数数字过大溢出
            if (deltaQuota < 0) {
                this.leftQuota = capacity;
                this.leakingTs = nowTs;
                return;
            }
            // 腾出空间太小，最小单位是1 这块是为了简化
            if (deltaQuota < 1) {
                return;
            }
            //扩大调用量
            this.leftQuota = this.leftQuota + deltaQuota;
            //更新上次漏水时间
            this.leakingTs = nowTs;
            //调整调用量为最大容量
            if (this.leftQuota > this.capacity) {
                this.leftQuota = this.capacity;
            }
        }
    
        /**
         * 消耗
         * @param quota
         * @return
         */
        boolean watering(int quota) {
            makeSpace();
            if (this.leftQuota >= quota) {
                this.leftQuota = this.leftQuota - quota;
                return true;
            }
            return false;
        }
    }
    
    private Map<String, Funnel> funnels = new HashMap<>();
    
    
    /**
     * 初始化一个漏斗
     * @param userId 用户id
     * @param actionKey 用户请求的限流key
     * @param capacity 漏斗容量
     * @param leakingRate 漏斗流出率
     * @return
     */
    public boolean isActionAllowed(String userId, String actionKey, int capacity, float leakingRate) {
        String key = String.format("%s:%s", userId, actionKey);
        Funnel funnel = funnels.get(key);
        if (funnel == null) {
            funnel = new Funnel(capacity, leakingRate);
            funnels.put(key, funnel);
        }
        // 需要1个quota
        return funnel.watering(1);
    }
    
    public static void main(String[] args) throws InterruptedException {
        FunnelRateLimiter funnelRateLimiter = new FunnelRateLimiter();
        while(true) {
            Thread.sleep(50);
            System.out.println(funnelRateLimiter.isActionAllowed("aaaa", "task", 1, 1));
        }
    }
}
