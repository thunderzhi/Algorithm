package org.cxz.algorithm.recurrence;

import java.util.List;


/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/5 12:52
 */
public class case120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for (int i = n-2; i >=0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] =Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
                System.out.println("dp["+i+"]["+j+"] = " + dp[i][j]);
            }
        }
        //dp[n-1][j] =min(dp[n][j],dp[n][j+1])+val
        return dp[0][0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) {
            dp[(n-1)%2][i] = triangle.get(n-1).get(i);
        }
        for (int i = n-2; i >=0 ; i--) {
            int ind = i%2;
            int preind = (ind==1?0:1);
            for (int j = 0; j <= i; j++) {
                dp[ind][j] =Math.min(dp[preind][j],dp[preind][j+1])+triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }
}
