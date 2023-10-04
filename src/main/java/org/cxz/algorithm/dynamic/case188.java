package org.cxz.algorithm.dynamic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/8/24 20:32
 */
public class case188 {
    
	public int maxProfit(int k, int[] prices) {
        if (prices.length == 0||k==0) {
            return 0;
        }
        int n = prices.length;
        k = Math.min(k, n);
        int[][] buy = new int[n+1][k + 1];
        int[][] sell = new int[n+1][k + 1];
        for (int i = 0; i <= k; ++i) {
            buy[0][i] = sell[0][i] = -prices[0];
        }
        buy[1][1] = -prices[0];
        sell[1][1] = 0;
        int ans = 0;
        for (int i = 1; i <= n; ++i) {             
            for (int j = 1; j <= k; ++j) {
                if(i==1&&j==1) continue;
buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j-1] - prices[i-1]);
sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j] + prices[i-1]); 
                if(ans<sell[i][j]){
                    ans = sell[i][j];
                } 
            }
        }
        return ans;
    }

    int INF = Integer.MIN_VALUE/2;
    //No more than j deals in the previous i day
    public int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        k = Math.min(k,n/2);
        int[][][] f = new int[n+1][k+1][2];
        //1 stock 0 money
        //f[0][0][1] = INF;
        // f[x][0][1] =inf f[x][0][0] = 0
        //f[1][1][1] = -prices[0];
        //f[1][1][0] = 0;
        //f[i][j][0] = max(f[i][j][0],  max(   f[i-1][j][0]   ,   f[i-1][j][1]+p[i-1]) );
        //f[i][j][1] = max(  f[i-1][j][1]    ,   f[i][j-1][0]-p[i-1] ) ;
        for(int j = 0;j<=k;j++){
            f[0][j][1]=INF;
        }
        //f[1][1][1] = -prices[0];
        //(1,1,1)====  (0,1,1 inf) (1,0,0)-p === -p0
        //(1,1,0)==== (0,1,0 : 0 )  ( 0,1,1 inf)-p === max(0,inf-p)
        for(int i = 1;i<=n;i++){
            int p = prices[i-1];
            f[i][0][1] = INF;
            for(int j = 1;j<=k;j++){
                int t = Math.max(f[i-1][j][1],f[i][j-1][0]-p);
                f[i][j][1] = t;
                t = Math.max(f[i-1][j][0],f[i-1][j][1]+p);
                f[i][j][0] = Math.max(f[i][j][0],t);
            }
        }
        return f[n][k][0];
    }
}
