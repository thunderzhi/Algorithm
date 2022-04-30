package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/26 12:40
 */
public class case081 {

    // ver1 cap and bymy
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(nums[0]==target||nums[n-1]==target) return true;
        int l =0,r=n-1,mid;
        while(l<=r&&nums[l]==nums[0])l++;
        while(l<=r&&nums[r]==nums[0])r--;
        if(l>r) return false;
        int tail = r;
        while(l<=r){
            mid= l+(r-l)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]>nums[tail]){
                if(nums[mid]> target&&target>nums[tail]){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            else{
                if(target<=nums[tail]&&nums[mid]<target){
                    l = mid +1;
                }
                else{
                    r = mid-1;
                }
            }
        }
        return false;
    }
}
