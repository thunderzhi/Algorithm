package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/4 17:38
 */
public class case070 {
    public static void main(String[] args) {
        int i = 4;
        int res = new case070().climbStairs2(i);
        System.out.println("res = " + res);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1] =1;
        for (int i = 2; i <= n; i++) {
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            dp[i%2]=dp[(i-1)%2]+dp[(i-2)%2];
            System.out.println("dp["+i%2+"] = " + dp[i%2]);
            //dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[(n)%2];
    }
}
