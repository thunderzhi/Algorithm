package org.cxz.algorithm.off.I;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/6 17:11
 */
public class caseOff057 {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        int n = nums.length;
        if(n<2) return new int[0];
        int l =0,r=n-1;
        while(l<r){
            if(nums[l]+nums[r]== target){
                ans[0]= nums[l];
                ans[1]= nums[r];
                return ans;
            }
            else if(nums[l]+nums[r] > target){
                r--;
            }
            else{
                l++;
            }
        }
        return new int[0];
    }
}
