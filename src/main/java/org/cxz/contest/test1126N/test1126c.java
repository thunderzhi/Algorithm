package org.cxz.contest.test1126N;

import org.cxz.algorithm.unionfind.Quick_Find_Unionset;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/11/26 22:35
 */
public class test1126b {

    public int[][] onesMinusZeros(int[][] grid) {
        int[][] g = grid;
        int m = g.length,n= g[0].length;
        int[] OneRows = new int[m];
        int[] ZeroRows = new int[m];
        int[] OneCols = new int[n];
        int[] ZeroCols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j]==0) {
                    ZeroRows[i]++;
                    ZeroCols[j]++;
                }
                else{
                    OneRows[i]++;
                    OneCols[j]++;
                }
            }
        }
        int[][] diff = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //onesRowi + onesColj - zerosRowi - zerosColj
                diff[i][j] = OneRows[i]+ OneCols[j]-ZeroRows[i]-ZeroCols[j];
            }
        }
        return diff;
    }
}
