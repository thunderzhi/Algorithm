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

    // ver 2 dp recommend
    public int coinChange2(int[] coins, int amount) {
        //dp[i][j] = min(dp[i-1][j],dp[i][j-x]+1)
        int n = coins.length;
        int[] dp = new int[amount+1];//miss
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for (int i = 0; i <n ; i++) {
            int x = coins[i];
            for (int j = x; j <=amount; j++) {
                if(dp[j-x]==-1){continue;}//cant reach
                if(dp[j]==-1||dp[j]>dp[j-x]+1){
                    dp[j]=dp[j-x]+1;
                }
            }
        }
        return dp[amount];
    }
}
