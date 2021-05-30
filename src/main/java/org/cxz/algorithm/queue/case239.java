package org.cxz.algorithm.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/30 17:53
 */
public class case239 {
    public static void main(String[] args) {

    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        if (k==0){
            return new int[]{};
        }
        Deque<Integer> q = new LinkedList<>();
        int ind =0;
        while (ind<nums.length){
            if (!q.isEmpty()&&q.peekFirst()+k<=ind){
                q.pollFirst();
            }
            while (!q.isEmpty()&&nums[q.peekLast()]<nums[ind]){
                q.pollLast();
            }
            q.offerLast(ind);
            ind++;
            if(ind>=k){
                ans[ind-k]=nums[q.peekFirst()];
            }
        }
        return ans;
    }

}
