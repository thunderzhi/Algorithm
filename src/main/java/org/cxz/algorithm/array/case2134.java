package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/2 23:22
 */
public class case2134 {

    public int minSwaps(int[] nums) {
        int n =nums.length;
        int cnt1 = 0,cnt0 =0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                cnt1++;
            }
        }
        if(cnt1==n||cnt1==0){
            return 0;
        }
        int ans =n+1;
        int l =0,r = cnt1-1;
        for(int i=0;i<=r;i++){
            if(nums[i]==0){
                cnt0++;
            }
        }
        while(l<n){
            if(nums[l]==0){
                cnt0--;
            }
            l++;
            if(nums[(r+1)%n]==0){
                cnt0++;
            }
            r++;
            ans = Math.min(ans,cnt0);
        }
        return ans;
    }
}
