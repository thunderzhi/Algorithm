package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/11 23:58
 */
public class case377 {
    public static void main(String[] args) {

    }
    public int combinationSum4(int[] nums, int target) {
        /*
        f[j] represent use all num from nums to get sum ==j
        f[j] = f[j-x=0]+f[j-x=1]+f[j-x=2]+f[j-x=3]+f[j-x=4]+ …….+f[j-x=n]//x from nums 0~n
        */
        int[] dp = new int[target+1];
        dp[0]=1;
        for (int i = 1; i <=target ; i++) {
            for (int num : nums) {
                if(i-num<0){continue;}
                dp[i] += dp[i-num];
            }
        }

        return dp[target];
    }
}
