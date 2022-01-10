package org.cxz.algorithm.recurrence;


import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/10 11:13
 */
public class case416 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,11,5};
        boolean b = new case416().canPartition(arr);
        System.out.println("b = " + b);
    }
    //ver 1
    public boolean canPartition(int[] nums) {
        int sum =0;
        for (int i = 0; i <nums.length; i++) {
            sum += nums[i];
        }
        if(sum%2==1){
            return false;
        }
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];
        /*
        dp[i][j]  chose items from 0~i  equal to j===1
        1 include i
        dp[i][j] = dp[i-1][j-nums[i]]==1?1:0;
        2 not include i
        dp[i][j] = dp[i-1][j]==1?1:0;

         */
        dp[0][0]=1;
        boolean res = false;
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j <=sum ; j++) {
                if (i==n){
                    dp[i][j]= dp[i-1][j]==1?1:0;
                    System.out.println("1 dp["+i+"]["+j+"] = " + dp[i][j]);
                }
                else{
                    if(j-nums[i]>=0){
                        dp[i][j] = dp[i-1][j-nums[i]]==1?1:0;
                        System.out.println("2 dp["+i+"]["+j+"] = " + dp[i][j]);
                    }
                }
                System.out.println("3 dp["+(i-1)+"]["+j+"] = " + dp[i-1][j]);

                dp[i][j] |= dp[i-1][j];
                System.out.println("4 dp["+i+"]["+j+"] = " + dp[i][j]);

            }
        }
        return dp[n][sum/2]==1;
    }

    //ver 2
    public boolean canPartition2(int[] nums){
        int sum =0;
        for (int i = 0; i <nums.length; i++) {
            sum += nums[i];
        }
        if(sum%2==1){
            return false;
        }
        int n = nums.length;
        int[] dp = new int[sum+1];
        dp[0]=1;
        sum =0;
        for (int i = 0; i < n; i++) {//miss i start at 0
            sum += nums[i];
            for (int j = sum; j >=nums[i]; j--) {// miss j>=nums[i]
                dp[j] = dp[j]|dp[j-nums[i]];
            }
        }
        return dp[sum/2]==1;
    }
}
