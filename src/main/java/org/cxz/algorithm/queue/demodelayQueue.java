package org.cxz.algorithm.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/24 17:42
 */
public class demodelayQueue {
    public static class delayobj implements Delayed{

        public int customerNo;
        long expire;

        public delayobj(int customerNo,long expire){
            this.customerNo = customerNo;
            this.expire = expire;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return expire - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            long o1 = this.getDelay(TimeUnit.MILLISECONDS);
            long o2 = o.getDelay(TimeUnit.MILLISECONDS);
            return  Long.compare(o1,o2);

        }
    }

    public static void main(String[] args) throws Exception {
        DelayQueue<Delayed> queue = new DelayQueue<>();
        long time = System.currentTimeMillis()+10000;
        queue.offer(new delayobj(1,time+500));
        queue.offer(new delayobj(2,time+400));
        queue.offer(new delayobj(3,time+300));
        queue.offer(new delayobj(4,time+100));
        queue.offer(new delayobj(5,time+200));

        while(!queue.isEmpty()){
            delayobj take = (delayobj)queue.take();
            System.out.println(take.customerNo);

        }

    }
}
