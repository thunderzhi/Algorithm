package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/22 16:39
 */
public class case343 {

    public int max =0;
    public int integerBreak(int n) {
        for(int i=2;i<=n;i++){
            getMultiply(n,i);
        }
        return max;
    }
    public void getMultiply(int n,int k){
        int mod = n%k;
        int quotient = n/k;
        int product = 1;
        for(int i = 0;i<k;i++){
            product = product*(quotient+(i<mod?1:0));
        }
        if(product>max){
            max = product;
        }
        return;
    }

    //dp
    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = i - 1; j > (i - 1) / 2; j--) {
                dp[i] = Math.max(dp[i], j * (i - j));
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
                dp[i] = Math.max(dp[i], j * dp[(i - j)]);
                dp[i] = Math.max(dp[i], dp[j] * dp[(i - j)]);
            }
        }
        return dp[n];
    }
}
