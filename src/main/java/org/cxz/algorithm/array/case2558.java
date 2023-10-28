package org.cxz.algorithm.array;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/28 9:51
 */
public class case2558 {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->{return b-a;});
        long tot = 0;
        for(int g: gifts ){
            pq.offer(g);
            tot += (long)g;
        }
        int cnt = 0;
        while(cnt<k){
            if(pq.isEmpty()) break;
            int h = pq.poll();
            int leave = (int)Math.sqrt(h);
            int take = h -leave;
            tot -= take;
            if(leave>0) pq.offer(leave);
            cnt++;
        }

        return tot;
    }
}
