package org.cxz.contest.test349week;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/6/4 10:25
 */
public class test0618b {


    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int c = Math.abs(nums[i]-nums[i-1]);
            ans = Math.min(ans,c);
        }
        return ans;
    }
}
