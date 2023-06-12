package org.cxz.contest.test349week;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/6/4 10:25
 */
public class test0611b {
    public int findNonMinOrMax(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n-1],min = nums[0];
        if(max==min) return -1;
        int ans = -1;
        for (int x:nums) {
            if(x==max||x==min)continue;
            ans = x;
            break;
        }
        return ans;
    }
}
