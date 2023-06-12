package org.cxz.contest.test2023341week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/16 10:13
 */
public class test0416a {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length,n = mat[0].length;
        int cnt =0,ans = 0;
        for (int i = 0; i < m; i++) {
            int t = 0;
            for (int j = 0; j < n; j++) {
                if(mat[i][j]==1){
                    t++;
                }
            }
            if(t>cnt){
                cnt = t;
                ans = i;
            }
        }
        return new int[]{ans,cnt};

    }
}
