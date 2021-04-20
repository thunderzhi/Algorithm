package org.cxz.algorithm.treepack;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/20 21:31
 */
public class case347 {
    public class TwoTuple<A,B> {
        public final A first;

        public final B second;

        public TwoTuple(A a, B b){
            first = a;
            second = b;
        }
    }


    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<TwoTuple<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<TwoTuple<Integer, Integer>>() {
            @Override
            public int compare(TwoTuple<Integer, Integer> o1, TwoTuple<Integer, Integer> o2) {
                return o1.second - o2.second;
            }
        });
        for (Integer integer : map.keySet()) {
            TwoTuple<Integer, Integer> tw = new TwoTuple<Integer, Integer>(integer,map.get(integer));
            pq.offer(tw);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll().first;
        }

        return ans;


    }
}
