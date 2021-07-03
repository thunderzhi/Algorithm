package org.cxz.algorithm.search;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/3 21:27
 */
public class case704 {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int l =0;
        int r = nums.length-1;
        int mid = 0;
        while(l<r){
            mid = (l+r)>>1;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                l = mid+1;
            }
            else{
                r= mid-1;
            }
        }

        return nums[l]==target?l:-1;


    }
}
