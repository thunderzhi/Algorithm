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
}
