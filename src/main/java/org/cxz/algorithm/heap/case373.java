package org.cxz.algorithm.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/14 9:40
 */
public class case373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>((o1, o2)->o2.get(2)-o1.get(2));
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] +nums2[j];
                if(pq.size()<k||sum <pq.peek().get(2)){
                    pq.offer(new ArrayList<>(Arrays.asList(nums1[i],nums2[j],sum)));
                    if(pq.size()>k){
                        pq.poll();
                    }
                }
                else{
                    break;
                }

            }
        }
        while (pq.size()>k){
            pq.poll();
        }
        for (List<Integer> integers : pq) {
            List<Integer> item = new ArrayList<>();
            item.add(integers.get(0));
            item.add(integers.get(1));
            ans.add(item);
        }
        return  ans;
    }

}
