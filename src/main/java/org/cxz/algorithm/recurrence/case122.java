package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/6 11:09
 */
public class case122 {

    public static void main(String[] args) {
        int[] p = new int[]{7,1,5,3,6,4};
        int res = new case122().maxProfit2(p);
        System.out.println("res = " + res);
    }

    //greedy
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                sum += prices[i]-prices[i-1];
            }
        }
        return sum;
    }

    //dp
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[2][2];
        //0 present no stock,1 present have stock
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        int n = prices.length;
        /*
        dp[i][0]= max of( dp[i-1][0]  or  dp[i-1][1]+price[i])
        dp[i][1]=max of( dp[i-1][1]  or  dp[i-1][0]-price[i])
        dp[n-1][0] > dp[n-1][1]
         */
        for (int i = 1; i < prices.length; i++) {
            int ind = i%2;
            int preind = ind==1?0:1;
            dp[ind][0]= Math.max(dp[preind][0],dp[preind][1]+prices[i]);
            dp[ind][1]= Math.max(dp[preind][1],dp[preind][0]-prices[i]);
        }

        return dp[(n-1)%2][0];
    }


}
