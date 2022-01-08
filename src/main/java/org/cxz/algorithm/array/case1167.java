package org.cxz.algorithm.array;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: todo
 * @date 2021/12/22 10:34
 */
public class case1167 {

    public static void main(String[] args) {

    }
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.offer(stick);
        }
        int ans = 0;
        while (pq.size()>1){
            int a = pq.poll();
            a+= pq.poll();
            pq.offer(a);
            ans +=a;
        }
        return ans;
    }

}
