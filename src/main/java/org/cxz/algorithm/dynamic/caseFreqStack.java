package org.cxz.algorithm.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/11 19:01
 */
public class caseFreqStack {

    public PriorityQueue<int[]> pq ;
    public Map<Integer,Integer> map;
    public int ind;
    public caseFreqStack() {
        map = new HashMap();
        pq = new PriorityQueue<int[]>((o1, o2)->{
            if(o1[1]==o2[1]) return o2[2]-o1[2];
            return o2[1]-o1[1];
        });
        ind =0;
    }

    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        int cnt = map.get(val);
        ind++;
        pq.offer(new int[]{val,cnt,ind});
    }

    public int pop() {
        int[] arr = pq.poll();
        int val = arr[0];
        map.put(val,arr[1]-1);

        return val;
    }
}
