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
    // ver 2 binary
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] len = new int[n+1];
        len[0] = nums[0];
        int ans = 1;
        for(int i =1;i<n;i++){
            int k = nums[i];
            int ind = find01(len,ans,k);
            //System.out.println("len: "+Arrays.toString(len));
            //System.out.println("ans: "+ans +" k: "+k +" ind: "+ind);
            len[ind] = k;
            ans = Math.max(ans,ind+1);
        }
        return ans;
    }

    public int find01(int[] arr,int n,int k){
        int l = 0, r = n,mid;
        while(l<r){
            mid = l+(r-l)/2;
            if(arr[mid]<k){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        return l ;
    }

}
