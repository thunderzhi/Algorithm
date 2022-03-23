package org.cxz.algorithm.off.II;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/21 15:56
 */
public class caseOffII009 {

    //ver1
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(k<=1) return 0;
        int ans = 0;
        int l = 0,r=0;
        int m =1;
        // while(l<=r&&r<=n-1){
        while( r<=n-1){
            m *= nums[r];
            // while(l<=r&&l<n-1&&m>=k){
            while( m>=k){
                m /= nums[l];
                l++;
            }
            ans += (r-l+1);
            r++;
        }
        return ans;
    }
}
