package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/7 11:09
 */
public class case300 {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        //dp[i] present end with i the longest serial
        //dp[i]=max( dp[j] +1)
        int n = nums.length;
        int[] dp = new int[n+1];
        int ans = 0;
        for (int i =0; i <n; i++) {// miss i start at 0
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(nums[j]>=nums[i]){
                    continue;
                }
                dp[i]= Math.max(dp[i],dp[j]+1);
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

}
