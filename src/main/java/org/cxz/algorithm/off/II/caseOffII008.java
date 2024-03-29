package org.cxz.algorithm.off.II;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/21 12:24
 */
public class caseOffII008 {

    //ver 1 binary
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        long[] presum = new long[n+1];
        //presum[i] - presum[x]>= target  [x-1,i-1]
        //presum[i] -target >= presum[x]   [x-1,i-1]
        int left=0;
        for(int i = 0;i<n;i++){
            presum[i+1] = presum[i] + nums[i];
            int ind = find01(presum,left,i+1,presum[i+1]-target);
            if(ind!=-1){
                int length = i-ind+1;
                ans = Math.min(ans,length);
                left = ind;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

    public int find01(long[] arr,int l,int r,long target){
        while(r-l>3){
            int mid = l+(r-l)/2;
            if(arr[mid]>target){
                r = mid-1;
            }
            else{
                l = mid;
            }
        }
        for(int i=r;i>=l;i--){
            if(arr[i]<=target) return i;
        }
        return -1;
    }

    //ver2 slide window
    public int minSubArrayLen2(int target, int[] nums) {

        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int l=0,r= 0;
        int sum = 0;
        while(r<n){
            sum += nums[r];
            r++;

            while(l<r&&(sum-nums[l])>=target){
                sum -= nums[l];
                l++;
                //ans = Math.min(ans,r-l);
            }
            if(sum>=target){ans = Math.min(ans,r-l);}
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

}
