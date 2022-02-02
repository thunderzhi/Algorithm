package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/1 11:35
 */
public class case2140 {

    //not test
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        int[][] dp = new int[n+1][2];
        dp[1][0]=0;
        dp[1][1]=questions[0][0];
        for(int i=2;i<=n;i++){
            dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1]);
            int q = questions[i-1][0];
            dp[i][1] = q;
            for(int k = i-1;k>0;k--){
                if(questions[k-1][1]+k<i){
                    dp[i][1]=Math.max(dp[i][1],dp[k][1]+q);
                }
            }
        }
        return Math.max(dp[n][0],dp[n][1]);
    }
}
