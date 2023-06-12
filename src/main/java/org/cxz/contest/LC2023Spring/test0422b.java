package org.cxz.contest.LC2023Spring;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/22 14:57
 */
public class test0422a {
    public int[] merge(int a ,int b ,int[] arr ){
        int len = arr.length;
        int[] res = new int[len-1];
        int c = arr[a]+arr[b];
        for (int i = 0; i <a; i++) {
            res[i] = arr[i];
        }
        res[a] = c;
        for (int i = a+1; i <res.length ; i++) {
            res[i] = arr[i+1];
        }
        return res;
    }
    public int[] supplyWagon(int[] supplies) {
        int n= supplies.length;
        int[] sup = supplies.clone();
        int[] res= new int[n];
        int k = n;
        while(k>n/2){
            // int[]  sum- indx
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2)->{
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            });
            for (int i = 0; i < k-1; i++) {
                int c = sup[i]+ sup[i+1];
                if(pq.isEmpty()||c< pq.peek()[0]){
                    pq.offer(new int[]{c,i,i+1});
                }
            }
            int[] poll = pq.poll();
            int idx1 = poll[1],idx2 = poll[2];
            // find 2 small index
            res = merge(idx1,idx2,sup);
            sup = res;
            pq.clear();
            k = res.length;
        }
        return res;
    }

}
