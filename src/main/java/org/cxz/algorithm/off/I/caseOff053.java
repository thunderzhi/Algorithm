package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/16 11:46
 */
public class caseOff053 {


    //ver 1
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return 0;//miss
        int start = find01(nums,target);
        if(start==n||start==-1) return 0;
        int end = find01(nums,target+1)-1;
        return end-start+1;
    }
    //find first 1
    public int find01(int[] nums,int target){
        int n = nums.length;
        if(nums[n-1]<target) return n;
        if(nums[0]>target) return -1;
        int l = 0,r= n-1;
        int mid =0;
        while(l<r){
            mid = l+(r-l)/2;
            if(nums[mid]>= target){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
}
