package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/6 11:46
 */
public class case198 {
    public static void main(String[] args) {
        int[] num = new int[]{2,7,9,3,1};
        int res = new case198().rob(num);
        System.out.println("res = " + res);


    }
    public int rob(int[] nums) {
        /*
        dp[n][0] present max value in n and dont steal n
        dp[n][1] present max value in n and must steal n
        dp[n][0] = max of (dp[n-1][0]) or (dp[n-1][1])   steal or not (n-1)
        dp[n][1] = dp[n-1][0]+nums[i])
        dp[0]= nums[0]
        dp[1]= nums[1]
         */
        int n = nums.length;
        int[][] dp = new int[2][2];
        dp[0][0]=0;
        dp[0][1]= nums[0];

        for (int i = 1; i <n; i++) {
            int ind = i%2;
            int preind = ind==1?0:1;
            dp[ind][0] = Math.max(dp[preind][0],dp[preind][1]);
            dp[ind][1] = dp[preind][0]+nums[i];

        }
        int N = (n-1)%2;
        return Math.max(dp[N][0],dp[N][1]);
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n+1][2];
        for(int i = 1;i<=n;i++){
            f[i][0] =Math.max(f[i-1][1],f[i-1][0]);
            f[i][1] = f[i-1][0]+nums[i-1];
        }
        return Math.max(f[n][0],f[n][1]);
    }
}
