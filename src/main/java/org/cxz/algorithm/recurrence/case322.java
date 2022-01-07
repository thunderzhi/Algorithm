package org.cxz.algorithm.recurrence;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/7 10:25
 */
public class case322 {
    public static void main(String[] args) {

    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];//miss
        Arrays.fill(dp,-1);
        dp[0] = 0;
        //dp[i]= dp[i-c] +1;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                int coin = coins[j];
                //not use coin
                if(i-coin<0){
                    continue;
                }
                //this value impossible
                if(dp[i-coin]==-1){
                    continue;
                }
                //first time set OR find the better answer
                if(dp[i]==-1||dp[i]>dp[i-coin]+1){
                    dp[i]= dp[i-coin]+1;
                }
            }
        }
        return  dp[amount];
    }
}
