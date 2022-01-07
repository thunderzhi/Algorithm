package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/6 14:19
 */
public class case152 {
    public static void main(String[] args) {
      // int[]  arr = {2,3,-2,4};
        int[]  arr = {-2,0,-1};
        int res = new case152().maxProduct(arr);
        System.out.println("res = " + res);

    }
    //error exist negative num
    public int maxProduct(int[] nums) {
        /*
        int max =intMIN;
        int pre =1;
       dp[n][0] 以n结尾 不包含n的最大连续子数组值
       dp[n][1] 以n结尾 包含n的最大连续子数组
        dp[n][0]  present in n ,the longest subarray max multipy  , without n
        dp[n][1]  present in n ,the longest subarray max multipy  , include n

        dp[n][0] = max(dp[n-1][0],dp[n-1][1]);
        dp[n][1]= max( dp[n-1][1]*nums[i],  nums[i])
        (pre>0&&nums[n]>0) OR (pre<0 && nums[n]<0)=====>dp[n][1]
         */

        int n = nums.length;
        if(n==0){
            return 0;
        }
        int[][] dp = new int[2][n+1];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for (int i = 1; i <=n; i++) {
            int ind = i%2;
            int preind = ind==1?0:1;
            dp[ind][0]= Math.max(dp[preind][0],dp[preind][1]);
            if(i<n){
                dp[ind][1]= Math.max(dp[preind][1]*nums[i],nums[i]);
            }
            else{
                dp[ind][1]= Math.max(dp[preind][0],dp[preind][1]);
            }
        }
        return Math.max(dp[(n - 1) % 2][0],dp[(n - 1) % 2][1]);
    }
    public int maxProduct2(int[] nums) {

        int n = nums.length;
        if(n==0){
            return 0;
        }
        int ans = Integer.MIN_VALUE;// miss ans should be min
        int max = 1;
        int min = 1;

        int cur = 0;
        for (int i = 0; i < n; i++) {// miss i start at 0
            cur = nums[i];
            if(cur<0){
                int tmp = min;
                min = max;
                max = tmp;
            }
            min = Math.min(min*cur,cur);
            max = Math.max(max*cur,cur);
            ans = Math.max(ans,max);
        }
        return ans;


    }



}
