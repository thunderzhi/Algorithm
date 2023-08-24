package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/25 0:29
 */
public class case1267 {
    public int countServers(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[] cntrow = new int[m];
        int[] cntcol = new int[n];
        int tot = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==0) continue;
                tot++;
                cntrow[i]++;
                cntcol[j]++;
            }
        }
        int cant = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==0) continue;
                if(cntrow[i]==1&&cntcol[j]==1){
                    cant++;
                }
            }
        }
        return tot- cant;
    }
}
