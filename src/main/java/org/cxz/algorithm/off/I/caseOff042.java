package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/22 15:46
 */
public class caseOff042 {

    //ver 1
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        int min = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
            ans = Math.max(ans, nums[i]);
            ans = Math.max(ans,sum-min);
            min = Math.min(min,sum);
        }
        return ans;
    }

    //ver 2 dp
    public int maxSubArray2(int[] nums) {
        //dp[i] = nums[i-1]
        //dp[i] = max(dp[i-1]+num[i-1], dp[i]);
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 1;i<=n;i++){
            dp[i] = nums[i-1];
            dp[i] = Math.max(dp[i],dp[i-1]+nums[i-1]);
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}
