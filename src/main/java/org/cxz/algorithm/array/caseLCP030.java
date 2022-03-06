package org.cxz.algorithm.array;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/6 21:54
 */
public class caseLCP030 {
    public int magicTower(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i =0;i<n;i++) sum += nums[i];
        if(sum<0) return -1;
        int ans = 0;
        long hp =1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i =0;i<n;i++){
            if(nums[i]<0){
                pq.offer(nums[i]);
                if(hp+nums[i]<=0){
                    ans++;
                    hp -= pq.poll();
                }
            }
            hp+= nums[i];
        }
        return ans;
    }
}
