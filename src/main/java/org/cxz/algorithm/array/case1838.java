package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/4 13:09
 */
public class case1838 {

    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        if(n==1) return 1;
        Arrays.sort(nums);
        long[] sum = new long[n+1];
        for(int i=0;i<n;i++){
            sum[i+1] = sum[i]+nums[i];
        }
        int l = 0,r = 1,ans =1;
        while(r<=n){
            if((sum[r]-sum[l]+k)>=(nums[r-1]*(r-l))){
                ans = Math.max(ans,r-l);
                r++;
            }
            else{
                while((sum[r]-sum[l]+k)<(nums[r-1]*(r-l))){
                    l++;
                }
            }
        }
        return ans;
    }
}
