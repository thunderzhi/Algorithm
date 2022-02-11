package org.cxz.algorithm.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/11 13:01
 */
public class case1353 {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events,(o1, o2)->{
            return o1[0]-o2[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int ans = 0;
        int i =0,cur =1;
        while(i<n||!pq.isEmpty()){
            while(i<n&&events[i][0]==cur){
                pq.offer(events[i][1]);
                i++;
            }
            while(!pq.isEmpty()&&pq.peek()<cur){
                pq.poll();
            }
            if(!pq.isEmpty()){
                ans++;
                pq.poll();
            }
            cur++;
        }
        return ans;
    }
}
