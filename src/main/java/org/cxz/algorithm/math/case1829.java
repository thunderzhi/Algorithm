package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/3 14:56
 */
public class case1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] ans = new int[n];
        int max = ( 1<<maximumBit) - 1;
        int sum =0;
        for(int i=0;i<n;i++){
            sum ^= nums[i];
            ans[n-1-i] = sum^max;
        }
        return ans;
    }
}
