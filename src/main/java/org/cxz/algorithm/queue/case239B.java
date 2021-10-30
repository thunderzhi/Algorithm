package org.cxz.algorithm.queue;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/30 17:53
 */
public class case239B {
    public static void main(String[] args) {

    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<Integer>();
        //List<Integer> ans = new ArrayList<>();
        int[] ans = new int[nums.length-k+1];//ans size = n-k+1
        int ind =0;
        for (int i = 0; i < nums.length; i++) {
            //any element in tail smaller than nums[i] will pop
            while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]){
                //
                dq.pollLast();
            }
            //now nums[i] is less bigger element in the window
            dq.offerLast(i);
            //now the first element is not included in the window
            if(i-dq.peekFirst()==k){
                dq.pollFirst();
            }
            //not get the window size
            if(i+1<k){
                continue;
            }
            //reach the window size,put the element in the head to the array
            ans[ind++]=nums[dq.peek()];
        }

        return ans;
    }

}
