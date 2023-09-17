package org.cxz.algorithm.recurrence;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/9 15:59
 */
public class case213 {
    public static void main(String[] args) {

    }
    //version 1
    public int rob(int[] nums) {
        //n
        /*
        dp[n][0]   dont steal the nth house MAX
        dp[n][1]   steal the nth house MAX
        if steal 0 ,u cant steal n-1 ===>dp[n-1][0] is we need
        dp[n][0] =max(dp[n-1][0],dp[n-1][1] )
        dp[n][1] = dp[n-1][0]+nums[i]
        if dont steal 0 ,dp[0][0]=0,dp[0][1]=0
        dp[n-1][1] is we want
        return  max of( dp[n-1][1]  ,dp[n-1][0])
        */
        int n = nums.length;
        if(n==1){
            return nums[0];  //miss
        }
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int ans1 = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        ans1 = dp[n - 1][0];
        int ans2 = 0;
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        ans2 = dp[n - 1][1];
        return Math.max(ans1, ans2);
    }

    //version 2 two array
    public int rob2(int[] nums) {
        //n
        /*
        dp[n][0]   dont steal the nth house MAX
        dp[n][1]   steal the nth house MAX
        if steal 0 ,u cant steal n-1 ===>dp[n-1][0] is we need
        dp[n][0] =max(dp[n-1][0],dp[n-1][1] )
        dp[n][1] = dp[n-1][0]+nums[i]
        if dont steal 0 ,dp[0][0]=0,dp[0][1]=0
        dp[n-1][1] is we want
        return  max of( dp[n-1][1]  ,dp[n-1][0])
        */
        int n = nums.length;
        if(n==1){
            return nums[0];  //miss
        }
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int ans1 = 0;
        for (int i = 1; i < n; i++) {
            int ind = i%2;
            int preind = ind==1?0:1;
            dp[ind][0] = Math.max(dp[preind][0], dp[preind][1]);
            dp[ind][1] = dp[preind][0] + nums[i];
        }
        ans1 = dp[(n - 1)%2][0];
        int ans2 = 0;
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            int ind = i%2;
            int preind = ind==1?0:1;
            dp[ind][0] = Math.max(dp[preind][0], dp[preind][1]);
            dp[ind][1] = dp[preind][0] + nums[i];
        }
        ans2 = dp[(n - 1)%2][1];
        return Math.max(ans1, ans2);
    }

    public int rob3(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] arr1 = Arrays.copyOfRange(nums,0,n-1);
        int[] arr2 = Arrays.copyOfRange(nums,1,n );
        int ans = steal(arr1);
        ans = Math.max(ans,steal(arr2));
        return ans;
    }
    public int steal(int[] arr){
        int n = arr.length;
        int[][] f = new int[n+1][2];
        for(int i = 1;i<=n;i++){
            f[i][0] = Math.max(f[i-1][0],f[i-1][1]);
            f[i][1] = f[i-1][0]+arr[i-1];
        }
        return Math.max(f[n][0],f[n][1]);
    }
}
