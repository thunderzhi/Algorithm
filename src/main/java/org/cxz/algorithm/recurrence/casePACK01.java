package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/10 12:01
 */
public class casePACK01 {

    //  W represent MAX weight
    // n represent MAX count
    // arr[i][0] represent item i weight
    // arr[i][1] represent item i value
    public int max01(int W,int n,int[][] nums ){
        /*
        dp[i][j]   represent i items and weight is j  MAX value
        dp[i][j] = dp[i-1][j-nums[i]] +Wi  include i item
        dp[i][j] = dp[i-1][j] not include i item and weight not heavier than j

        dp[i][j] = max(dp[i-1][j-nums[i]] +W[i],dp[i-1][j])
        * */
        int[] w = new int[n+5];//weight
        int[] v = new int[n+5];//value
        int[][] dp = new int[n+5][W+5];
        for (int i = 0; i < nums.length; i++) {
            w[i]=nums[i][0];
            v[i]=nums[i][1];
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=w[i]){
                    dp[i][j] =Math.max(dp[i-1][j-w[i]] +v[i],dp[i][j]);
                }
            }
        }
        return dp[n][W];

    }
}
