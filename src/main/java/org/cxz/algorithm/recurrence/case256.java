package org.cxz.algorithm.recurrence;

import java.security.CodeSigner;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/8 10:35
 */
public class case256 {

    public static void main(String[] args) {

    }

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i]= costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            int ind = i%2;
            int preind = ind==1?0:1;
            dp[ind][0] = Math.min(dp[preind][1],dp[preind][2])+ costs[i][0];
            dp[ind][1] = Math.min(dp[preind][0],dp[preind][2])+ costs[i][1];
            dp[ind][2] = Math.min(dp[preind][0],dp[preind][1])+ costs[i][2];

        }
        int ind = (n-1)%2;
        return Math.min(dp[ind][0], Math.min(dp[ind][2],dp[ind][1]));
    }

}
