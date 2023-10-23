package org.cxz.contest.test104dweek;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/13 22:28
 */
public class test0513c {
    public long maximumOr(int[] nums, int k) {
        // 12  8 4 --- 24  16 8
        // 9   8 1 --- 18  16 2
        //
        int n = nums.length;
        int[] RMax = new int[n];
        int[] LMax = new int[n];
        int[] RMin = new int[n];
        int[] LMin = new int[n];
        Deque<Integer> queue = new ArrayDeque<>();
        // max
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            while(!queue.isEmpty()&& nums[queue.peekLast()]<cur){
                int pind = queue.pollLast();
                RMax[pind] = i;
            }
            if(queue.isEmpty()){
                LMax[i] = -1;
            }
            else{
                if(nums[queue.peekLast()]==cur) LMax[i] = -1;
                else LMax[i] = queue.peekLast();
            }
            queue.offerLast(i);
        }
        while(!queue.isEmpty()){
            RMax[queue.pollLast()] = n;
        }
        return  1;




    }
}
