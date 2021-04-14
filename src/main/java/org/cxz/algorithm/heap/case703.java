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
    public void KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((o1,o2)->o1-o2);
        _k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);
        while(pq.size()>_k){
            pq.poll();
        }


        return pq.peek();
    }
}
