package org.cxz.algorithm.heap;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/31 17:09
 */
public class case2163 {

    public long minimumDifference(int[] nums) {
        int m = nums.length;
        int n = m/3;
        PriorityQueue<Integer> left = new PriorityQueue<Integer>((o1,o2)->{return o2-o1;});//
        PriorityQueue<Integer> right = new PriorityQueue<Integer>();
        long[] lsum = new long[m];
        long sum =0;
        for(int i = 0;i<m;i++){
            sum += nums[i];
            left.offer(nums[i]);
            if(left.size()<n) continue;
            if(left.size()>n){
                sum -= left.poll();
            }
            lsum[i] = sum;
        }
        long ans = Long.MAX_VALUE;
        sum=0;
        for(int i = m-1;i>=n;i--){
            sum += nums[i];
            right.offer(nums[i]);
            if(right.size()<n) continue;
            if(right.size()>n){
                sum -= right.poll();
            }
            ans = Math.min(ans,lsum[i-1]-sum);
        }
        return ans;
    }
}
