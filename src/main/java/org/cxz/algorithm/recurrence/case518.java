package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/11 23:58
 */
public class case518 {
    public static void main(String[] args) {

    }
    public int change(int amount, int[] coins) {
        /**
         dp[j] = dp[j] +dp[j-x];
         */

        int[] dp = new int[amount+1];
        dp[0]=1;
        int n = coins.length;
        for (int x :coins) {
            for (int j = x; j <=amount ; j++) {
                dp[j] += dp[j-x];
            }
        }
        return dp[amount];
    }
}
