package org.cxz.algorithm.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: greedy
 * @date 2022/9/11 22:53
 */
public class case857 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] A = new Integer[n];
        double totc = 1e9 ;
        //a,b w[a]/q[a] - w[b]/q[b]
        for (int i = 0; i < n; i++) {
            A[i] = i;
        }
        Arrays.sort(A,(a, b)->{
            return wage[a]*quality[b]- wage[b]*quality[a];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->{return b-a;});
        int totq = 0;
        // k-1
        for (int i = 0; i < k-1; i++) {
            totq += quality[A[i]];
            pq.offer(quality[A[i]]);
        }
        for (int i =k-1; i < n; i++) {
            totq+= quality[A[i]];
            double a = (wage[A[i]]*1.0)/(quality[A[i]]*1.0);
            double cost = totq*a;
            if(cost<totc) totc = cost;
            pq.offer(quality[A[i]]);
            int q = pq.poll();
            totq -= q;
        }
        return totc;
    }
}
