package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/17 0:00
 */
public class case1512 {

    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        int[] cnt = new int[101];
        for(int i = 0;i<nums.length;i++){
            ans +=cnt[nums[i]];
            cnt[nums[i]]++;
        }
        return ans;
    }
}
