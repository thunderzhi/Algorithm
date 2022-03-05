package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/5 16:15
 */
public class case304 {
    public int[][] f;
    //NumMatrix
    public case304(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        f = new int[m+1][n+1];
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                f[i][j] = f[i-1][j]+f[i][j-1]-f[i-1][j-1]+matrix[i-1][j-1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return f[row2][col2]-f[row1-1][col2]-f[row2][col1-1]+f[row1-1][col1-1];
    }
}
