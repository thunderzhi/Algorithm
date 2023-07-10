package org.cxz.algorithm.array;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: contest 327 Q2
 * @date 2023/7/10 21:28
 */
public class case2530 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{return b-a;});
        for(int i: nums){
            pq.offer(i);
        }
        int cnt =0;
        long ans =0;
        while(cnt<k){
            cnt++; 
            int t = pq.poll();
            ans +=t;
            int x = (t+2)/3;
            pq.offer(x);
        }
        return ans;
    }

}
