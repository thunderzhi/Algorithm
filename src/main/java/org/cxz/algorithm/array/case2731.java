package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/10 11:17
 */
public class case2731 {
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] arr = new long[n];
        for(int i =0;i<n;i++){
            long dir = s.charAt(i)=='R'?1L:-1L;
            arr[i] = nums[i]*1L+dir*d;
        }
        Arrays.sort(arr); 
        long ans =0, sum = 0 , mod= (long)1e9+7;
        for(int i = 0;i<n;i++){
            ans = ( ans +i*arr[i] - sum)%mod;
            sum += arr[i];
        }

        return (int)ans;
    }
}
