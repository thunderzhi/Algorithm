package org.cxz.algorithm.heap;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/14 13:37
 */
public class case215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->o1-o2);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);

            if(pq.size()>k){
                pq.poll();
            }

        }
        return pq.peek();
    }
}
