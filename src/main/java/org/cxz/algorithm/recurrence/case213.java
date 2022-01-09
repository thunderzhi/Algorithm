package org.cxz.algorithm.recurrence;

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

    public int rob(int[] nums) {
        //n
        /*
        dp[n][0]   dont steal the nth house MAX
        dp[n][1]   steal the nth house MAX
        dp[n][0]  MAX
        1 steal n-1 house or not
        dp[n][0] =max(dp[n-1][0],dp[n-1][1] )  if n is the last

        dp[n][1]  MAX
        1 not steal n-1
        dp[n][1] = dp[n-1][0]+nums[i]
        2 if n is the last ,cant steal the first 0 either
        dp[n][1] = dp[n-1][0]





        * */
        return 1;
    }
}
