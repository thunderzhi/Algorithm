package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/3 15:15
 */
public class case123 {
    //No more than j deals in the previous i day
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int INF = Integer.MIN_VALUE/2;
        // 1   2 deal  3 state
        int[][][] f= new int[n][3][2];
        //state 0 stock  1 money
        f[0][0][1] = 0;
        f[0][0][0] = INF;
        f[0][1][0] = -prices[0];
        f[0][1][1] = 0;
        f[0][2][0] = -prices[0];
        f[0][2][1] = 0;
        for(int i = 1;i<n;i++){
            int p = prices[i];
            f[i][0][0]=f[i-1][0][0];
            f[i][0][1]=f[i-1][0][1];;
            for(int j = 1;j<3;j++){
                int f0 = Math.max(f[i-1][j][0],f[i-1][j-1][1]-p);
                f[i][j][0] = Math.max(f[i-1][j-1][0],f0);
                int f1 = Math.max(f[i-1][j][1],f[i-1][j][0]+p);
                f[i][j][1] = Math.max(f[i-1][j-1][1],f1);
            }
        }
        return f[n-1][2][1];
    }

    // j deals in the previous i day
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int INF = Integer.MIN_VALUE/2;
        // 1   2 deal  3 state
        int[][][] f= new int[n][3][2];
        //state 0 stock  1 money
        f[0][1][0] = -prices[0];
        f[0][1][1] = INF;
        f[0][2][0] = INF;
        f[0][2][1] = INF;
        for(int i = 1;i<n;i++){
            int p = prices[i];
            f[i][0][0] = f[i-1][0][0];
            f[i][0][1] = f[i-1][0][1];

            f[i][1][0] =Math.max(f[i-1][1][0],f[i-1][0][1]-p);
            f[i][1][1] = Math.max(f[i-1][1][1],f[i-1][1][0]+p);

            f[i][2][0] = Math.max(f[i-1][2][0],f[i-1][1][1]-p);
            f[i][2][1] = Math.max(f[i-1][2][1],f[i-1][2][0]+p);
        }
        int ans = INF;
        for(int i=0;i<3;i++ ) {
            ans = Math.max(ans,f[n-1][i][1]);
        }
        return ans;
    }
}
