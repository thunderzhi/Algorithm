package org.cxz.algorithm.matrix;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/10 10:48
 */
public class case1289 {
    int n,INF;
    int[][] g,memo;
    public int minFallingPathSum(int[][] grid) {
        n = grid.length;
        g = grid;
        INF = 1<<30;
        memo = new int[n][n+1];
        for(int i=0;i<n;i++) Arrays.fill(memo[i],-1);
        return dfs(n-1,-1);
    }
    public int dfs(int row,int precol){
        if(memo[row][precol+1]!=-1){
            return memo[row][precol+1];
        }
        if(row==0){
            int res = 100;
            for(int i=0;i<n;i++){
                if(i!=precol){
                    res = Math.min(res,g[row][i]);
                }
            }
            return memo[row][precol+1] = res;
        }
        int res = INF;
        for(int i=0;i<n;i++){
            if(i!=precol){
                int t = dfs(row-1,i)+g[row][i];
                res = Math.min(res,t);
            }
        }
        memo[row][precol+1] = res;
        return res;
    }

    public int minFallingPathSum2(int[][] grid) {
        int[][] f = new int[n][n];
        // f[0][j] = g[0][j];
        // f[i][j] = min( f[i-1][k])+ g[i][j]
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i],INF);
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = grid[0][i];
        }
        int ans = INF;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(k==j)continue;
                    f[i][j] = Math.min(f[i][j],f[i-1][k]+grid[i][j]);
                }
                if(i==n-1&&ans>f[i][j]) ans = f[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            if(ans>f[n-1][i]) ans = f[n-1][i];
        }
        return ans;
    }
    public int minFallingPathSum3(int[][] grid) {
        n = grid.length;
        // g = grid;
        int INF = 1<<30;
        int[][] f = new int[n][n];
        // f[0][j] = g[0][j];
        // f[i][j] = min( f[i-1][k])+ g[i][j]
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i],INF);
        }
        int[][] memo = new int[2][3];// 0 min1 1 min2 2 idx of min1
        memo[0][0]=INF;memo[0][1]=INF;
        memo[1][0]=INF;memo[1][1]=INF;
        for (int i = 0; i < n; i++) {
            f[0][i] = grid[0][i];
            if(f[0][i]<memo[0][0]){
                memo[0][1] = memo[0][0];
                memo[0][0] = f[0][i];
                memo[0][2] = i;
            }
            else if(f[0][i]<memo[0][1]){
                memo[0][1] = f[0][i];
            }
        }

        int ans = INF;
        for (int i = 1; i < n; i++) {
            int r = i%2;
            memo[r][0]=INF;memo[r][1]=INF;
            for (int j = 0; j < n; j++) {
                f[i][j] = grid[i][j];
                if(j!=memo[r^1][2]){
                    f[i][j]  += memo[r^1][0];
                }
                else{
                    f[i][j]  += memo[r^1][1];
                }

                if(f[i][j]<memo[r][0]){
                    memo[r][1] = memo[r][0];
                    memo[r][0] = f[i][j];
                    memo[r][2] = j;
                }
                else if(f[i][j]<memo[r][1]){
                    memo[r][1] = f[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(ans>f[n-1][i]) ans = f[n-1][i];
        }
        return ans;
    }
}
