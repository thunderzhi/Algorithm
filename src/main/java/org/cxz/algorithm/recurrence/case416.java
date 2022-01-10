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

    }

    public boolean canPartition(int[] nums) {
        int sum =0;
        for (int i = 0; i <nums.length; i++) {
            sum += nums[i];
        }
        if(sum%2==1){
            return false;
        }
        int target = sum/2;
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n+1];

        /*
        dp[i][0]=
        dp[i][1]=


         */

        for (int i = 0; i < ; i++) {

        }





        
        
    }
}
