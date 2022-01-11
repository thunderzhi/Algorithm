package org.cxz.algorithm.recurrence;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/11 11:55
 */
public class case494 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
       // int[] arr ={2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53};
       // 1000
        int t = 3;
        int targetSumWays = new case494().findTargetSumWays2(arr, t);
        System.out.println("targetSumWays = " + targetSumWays);
    }

    //ver 1 dp where i from
    public int findTargetSumWays(int[] nums, int target) {
        /*
         f[i][j]= f[i-1][j-num[i]]+f[i-1][j+num[i]]

        * */
        int n = nums.length;
        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        //miss
        if(sum<Math.abs(target)){
            return 0;
        }

        int I = sum;
        int[][] dp = new int[n+1][2*sum+3];
        dp[0][I] =1;
        sum = 0;
        for (int i = 1; i <=n; i++) {
            int x = nums[i-1];

            System.out.println("------->x = " + x);
            for (int j = -sum; j <=sum ; j++) {
                int a =  (j+I-x);
                int b =  (j+I+x);
                System.out.println("(j+I-x) = " + a);
                System.out.println("(j+I+x) = " + b);

                System.out.println("dp["+(i-1)+"]["+(j-x)+"] = " + dp[i-1][a]);
                System.out.println("dp["+(i-1)+"]["+(j+x)+"] = " + dp[i-1][b]);
                dp[i][j+I-x] += dp[i-1][j+I];
                dp[i][j+I+x] += dp[i-1][j+I];



                //dp[i][j+I]= dp[i-1][j+I-x]+dp[i-1][j+I-x];
//                System.out.println("--dp["+i+"]["+(j)+"] = " + dp[i][j+I]);

            }
            sum +=x;
        }

        return dp[n][target+I];




        /*
        f[i][j] = f[i − 1][j − x] + f[i − 1][j + x]
        f[ind][j + x] += f[pre_ind][j];
        f[ind][j - x] += f[pre_ind][j];
        f[i][j + x] =f[i][j + x] + f[i-1][j];
        f[i][j - x] =f[i][j - x] + f[i-1][j];
        * */
       // int[][] dp =
 
    }
    //ver 2 improve
    public int findTargetSumWays2(int[] nums, int target) {
        int n = nums.length;
        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        //miss
        if(sum<Math.abs(target)){
            return 0;
        }
        int I = sum;
        int[][] dp = new int[2][2*sum+3];
        dp[0][I] =1;
        sum = 0;
        for (int i = 1; i <=n; i++) {
            int ind = i%2;
            int preind = ind ==1?0:1;
            int x = nums[i-1];
            Arrays.fill(dp[ind],0);// miss
            for (int j = -sum; j <=sum ; j++) {
                dp[ind][j+I-x] += dp[preind][j+I];
                dp[ind][j+I+x] += dp[preind][j+I];
            }
            sum +=x;
        }
        return dp[n%2][target+I];//miss 
    }

}
