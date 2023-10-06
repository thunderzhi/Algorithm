package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/9 15:10
 */
public class case714 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices, int fee) {
        /*
        dp[i][0] present i only cash   MAX ,
        1 [i-1][0] only cash ==>dp[i][0]=dp[i-1][0]
        2 [i-1][1] have stock sold at i ====>dp[i][0] = dp[i-1][1]+prices[i]-prices[i-1]-fee
        dp[i][0]= max(dp[i-1][0],dp[i-1][1]+prices[i]-prices[i-1]-fee);
        dp[i][1] present i only stock MAX,
        1 [i-1][0] only cash then buy stock at i ===> dp[i][1]= dp[i-1][0] -prices[i]
        2 [i-1][1] have stock and keep it ===> dp[i][1]= dp[i-1][1];
        dp[i][1] = max( dp[i-1][0] -prices[i] , dp[i-1][1] );

        * */
        int n = prices.length;
        int[][] dp = new int[2][2];
        dp[0][0] =0;
        dp[0][1] =-prices[0];
        for (int i = 1; i < n; i++) {
            int ind = i%2;
            int preind = ind==1?0:1;
            //dp[ind][0]=Math.max(dp[preind][0],dp[preind][1]+prices[i]-prices[i-1]-fee); only need price[i]
            dp[ind][0]=Math.max(dp[preind][0],dp[preind][1]+prices[i]-fee);
            dp[ind][1] = Math.max( dp[preind][0] -prices[i] , dp[preind][1] );
            System.out.println("dp["+ind+"][0] = " + dp[ind][0]+" dp["+ind+"][1] = " + dp[ind][1]);
            //System.out.println();

        }
        return dp[(n-1)%2][0];
    }


    int INF= Integer.MIN_VALUE/2;
    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int[][] f = new int[n+1][2];
        //1 stock 0 money
        // f[i][0]  = f[i-1][0] or f[i-1][1]+p[i-1]-fee;
        // f[i][1]  = f[i-1][1] or f[i-1][0]-p[i-1];
        // (1,0) === (0,0 0) (0,1, INF)+p[0]-fee;
        //(1,1) === (0,1 ,INF)  or (0,0)-p[0]
        f[0][1] = INF;
        for(int i =1;i<=n;i++){
            int p =prices[i-1];
            f[i][0] = Math.max( f[i-1][0] ,f[i-1][1]+p-fee);
            f[i][1] = Math.max( f[i-1][1] ,f[i-1][0]-p);
        }
        return f[n][0];
    }
}
