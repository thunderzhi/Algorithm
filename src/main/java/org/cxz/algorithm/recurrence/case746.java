package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/4 17:46
 */
public class case746 {
    public static void main(String[] args) {
        int[]  arr= {1,100,1,1,1,100,1,1,100,1};
        int res = new case746().minCostClimbingStairs(arr);
        System.out.println("res = " + res);

    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0]= cost[0];
        dp[1]= cost[1];
        for (int i = 2; i <=n ; i++) {
            if(i==n){
                dp[i]=Math.min(dp[i - 1] , dp[i - 2]  );
            }
            else{
                dp[i] = Math.min(dp[i - 1] , dp[i - 2]  )+cost[i];
            }
            System.out.println("dp["+i+"] = " + dp[i]);
        }
        return dp[n];
    }
}
