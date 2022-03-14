package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/14 17:28
 */
public class case1911 {

    //ver 1 cap
    public long maxAlternatingSum1(int[] nums) {
        int n = nums.length;
        long sub_max =Integer.MIN_VALUE;
        long add_max = nums[0], a, b, ans = nums[0];
        for (int i = 1; i < n; i++) {
            a = Math.max(sub_max + nums[i], (long)nums[i]);
            b = add_max - nums[i];
            ans = Math.max(ans, Math.max(a, b));
            sub_max = Math.max(sub_max, b);
            add_max = Math.max(add_max, a);
        }
        return ans;
    }

    // ver2 dp
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[2][2];
        dp[0][1]=nums[0];
        dp[0][0]=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            int ind = i&1;
            int pre = ind^1;
            dp[ind][1] = Math.max(dp[pre][1],Math.max(dp[pre][0]+nums[i],nums[i]));
            dp[ind][0]= Math.max(dp[pre][1]-nums[i],dp[pre][0]);
        }
        return dp[(nums.length-1)%2][1];
    }
}
