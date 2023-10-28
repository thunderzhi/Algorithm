package org.cxz.contest.test331week;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/2/5 0:58
 */
public class test0205a {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{return b-a;});
        long sum = 0;
        for (int i = 0; i < gifts.length; i++) {
            sum += gifts[i];
            pq.offer(gifts[i]);
        }
        int cnt=0;
        while(cnt<k){
            int t = pq.poll();
            int left = (int)Math.floor(Math.sqrt(t));
            sum = sum - (t-left);
            pq.offer(left);
            cnt++;
        }
        return sum;
    }
}
