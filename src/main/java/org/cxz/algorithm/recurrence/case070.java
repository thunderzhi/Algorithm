package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/4 17:38
 */
public class case070 {

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1] =1;
        for (int i = 2; i <= n; i++) {
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
