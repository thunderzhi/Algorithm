package org.cxz.contest.test2023102dweek;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/15 22:27
 */
public class test0415b {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length,n  = grid[0].length;// row col
        int[] ans = new int[n];
        for (int c = 0; c < n; c++) {
            int max = 1;
            for (int r = 0; r < m; r++) {
                String s = String.valueOf(grid[r][c]);
                max = Math.max(max,s.length());
            }
            ans[c] = max;
        }
        return ans;
    }
}
