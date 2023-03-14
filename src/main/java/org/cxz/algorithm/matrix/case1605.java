package org.cxz.algorithm.matrix;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/3/14 14:53
 */
public class case1605 {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] ans = new int[rows][cols];
        for(int i = 0;i<rows;i++){
            // int x = rowSum[i];
            // int y = colSum[j];
            for(int j =0;j<cols;j++){
                int t = Math.min(rowSum[i],colSum[j]);
                ans[i][j] = t;
                rowSum[i]-=t;
                colSum[j]-=t;
            }
        }
        return ans;
    }

    public int[][] restoreMatrix2(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] mat = new int[m][n];
        for (int i = 0, j = 0; i < m && j < n; ) {
            int rs = rowSum[i], cs = colSum[j];
            if (rs < cs) { // 去掉第 i 行，往下走
                colSum[j] -= rs;
                mat[i++][j] = rs;
            } else { // 去掉第 j 列，往右走
                rowSum[i] -= cs;
                mat[i][j++] = cs;
            }
        }
        return mat;
    }
}
