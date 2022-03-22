package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/22 16:10
 */
public class caseOff047 {

    //ver1 ONN
    public int maxValue(int[][] grid) {
        //dp[i][j] = max(dp[i][j-1],dp[i-1][j])+g[i][j]
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i =1;i<=m ;i++){
            for(int j =1;j<=n ;j++){
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j])+grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }

    //ver2 On
    public int maxValue2(int[][] grid) {
        //dp[i][j] = max(dp[i][j-1],dp[i-1][j])+g[i][j]
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n+1];
        for(int i =1;i<=m ;i++){
            for(int j =1;j<=n ;j++){
                int ind = (i&1);
                int pre = (ind^1);
                dp[ind][j] = Math.max(dp[ind][j-1],dp[pre][j])+grid[i-1][j-1];
            }
        }
        return dp[(m&1)][n];
    }

    //ver 3 On
    public int maxValue3(int[][] grid) {
        //dp[i][j] = max(dp[i][j-1],dp[i-1][j])+g[i][j]
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n+1];
        for(int i =1;i<=m ;i++){
            for(int j =1;j<=n ;j++){
                //dp[j] = dp[j]+grid[i-1][j-1];
                dp[j] = Math.max(dp[j-1],dp[j])+grid[i-1][j-1];
                //dp[ind][j] = Math.max(dp[ind][j-1],dp[pre][j])+grid[i-1][j-1];
            }
        }
        return dp[n];
    }
}
