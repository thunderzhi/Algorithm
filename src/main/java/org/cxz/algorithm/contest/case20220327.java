package org.cxz.algorithm.contest;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/27 10:56
 */
public class case20220327 {
    public static void main(String[] args) {
        //int[] num = new int[]{1,1,2,3,5};
        int[] num = new int[]{1,1,2,2,3,3};
        int res = new case20220327().minDeletion(num);
        System.out.println("res = " + res);
    }

    public int minDeletion(int[] nums) {
        int n = nums.length;
        if(n<2) return 0;
        int[] dp = new int[n+1];
        //dp[i] = d[i-2]+2     nums[i-2]!=nums[i-1]
        // if i%2==0 ---->dp[i] = d[i-2]+2     nums[i-2]!=nums[i-1]
        // dp[i] = d[i-2] +(nums[i-2]==nums[i-1]?0:2); nums[i-2]==nums[i-1]
        // if i%2==1 dp[i]= d[i-1]+(nums[i-1]==nums[i]?0:1)
        int ans =0;
        dp[0]=1;
        dp[1] = dp[0]+(nums[1-1]==nums[1]?0:1);
        int cnt= 0;
        int[] mark = new int[3];
        mark[cnt%3] = 0;
        cnt++;
        if(nums[mark[(cnt-1)%3]]!=nums[1]){
            mark[(cnt++)%3] = 1;
        }
        for(int i = 2;i<n;i++){
            if((cnt&1)==1){
                dp[i] = dp[mark[(cnt-1)%3]]+(nums[mark[(cnt-1)%3]]==nums[i]?0:1);
                if(nums[mark[(cnt-1)%3]]!=nums[i]){
                    mark[cnt%3] = nums[i];
                    System.out.println("1cnt = " + cnt+" num: "+ nums[i]);
                    cnt++;
                }
            }
            else{
                dp[i] = dp[mark[(cnt-1)%3]]+1;
                mark[cnt%3] = nums[i];
                System.out.println("2cnt = " + cnt+" num: "+ nums[i]);

                cnt++;
            }
            System.out.println("cnt = " + cnt);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
