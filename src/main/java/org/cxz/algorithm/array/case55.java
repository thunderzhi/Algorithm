package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/22 16:11
 */
public class case55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        // int[] dp = new int[n+1];
        int[] dp = new int[n+1];
        dp[1] =nums[0];
        for(int i = 2;i<=n;i++){
            int cur = i%2;
            int pre = cur==1?0:1;
            // dp[i] = dp[i-1];
            dp[cur] = dp[pre];
            // if(dp[i-1]>=i-1){
            if(dp[pre]>=i-1){
                // dp[i] = Math.max(dp[i-1],i-1+nums[i-1]);
                dp[cur] = Math.max(dp[pre],i-1+nums[i-1]);
            }
            // if(dp[i]>=n-1) return true;
            if(dp[cur]>=n-1) return true;
        }
        return dp[n%2]>=n-1;
    }
}
