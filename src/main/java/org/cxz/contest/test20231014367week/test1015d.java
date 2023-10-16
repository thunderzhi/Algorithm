package org.cxz.contest.test20231014367week;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/14 23:58
 */
public class test1015d {
    public int[][] constructProductMatrix(int[][] grid) {
        int n =  grid.length, m = grid[0].length;
        int mod = 12345;
        int[] rowmulti = new int[n];
        for (int i = 0; i < n; i++) {
            int t = 1;
            for (int j = 0; j < m; j++) {
                t = (t*(grid[i][j]%mod))%mod;
            }
            rowmulti[i] = t;
        }
        System.out.println("rowmulti = " + Arrays.toString(rowmulti) );
        int[] row = new int[n];
        row[0]=1;
        for (int i = 1; i < n; i++) {
            row[i] =((row[i-1]%mod) *(rowmulti[i-1]%mod) )%mod;
        }
        int bot = 1;
        for (int i = n-1; i >=0; i--) {
            if(i+1<n){
                bot = ((bot%mod)*(rowmulti[i+1]%mod))%mod;
            }
            row[i] = (i-1>=0)? (bot*row[i-1])%mod: bot;
        }

        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            int x = row[i];
            int[] col = new int[m];
            col[0] = 1;
            for (int j = 1; j < m; j++) {
                col[j] =((col[j-1]%mod) *(grid[i][j-1]%mod) )%mod;
            }
            bot = 1;
            for (int j = m-1; j >=0; j--) {
                if(j+1<m){
                    bot = ((bot%mod)*(grid[i][j+1]%mod))%mod;
                    col[j] = (j>=1)? (bot*col[j-1])%mod:bot;
                }
                ans[i][j] = ((x%mod)*(col[j]%mod))%mod;
            }
        }
        return ans;
    }
}
