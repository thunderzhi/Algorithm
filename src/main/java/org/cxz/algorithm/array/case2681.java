package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/1 22:45
 */
public class case2681 {
    long MOD = (long)1e9+7;
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        long sum = 0,s = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            long cur = ((long)nums[i])%MOD;
            long pow = (cur*cur)%MOD;
            sum = (sum + (pow*((cur +s)%MOD))%MOD)%MOD;
            s = ( 2*s + cur)%MOD;
        }
        return (int)sum;
    } 
}
