package org.cxz.algorithm.recurrence;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/26 16:10
 */
public class case646 {

    //ver dp
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2)->{
            return o1[0]-o2[0];
        });
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                else {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }
        return dp[n - 1];
    }
}
