package org.cxz.algorithm.heap;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/13 22:01
 */
public class case703 {
    public PriorityQueue<Integer> pq;
    public int _k;
    public static void main(String[] args) {
//["KthLargest","add","add","add","add","add"]
//[[1,[]],[-3],[-2],[-4],[0],[4]]

    }
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((o1,o2)->o1-o2);
        _k = k;
        for (int num : nums) {
            if(pq.size()<k){
                pq.offer(num);
                continue;
            }
            if(num>pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }
    }

    public int add(int val) {
        if(pq.size()<_k){
            pq.offer(val);
            return pq.peek();
        }

        if(val>=pq.peek()){
            pq.poll();
            pq.offer(val);

        }

        return pq.peek();
    }
}
