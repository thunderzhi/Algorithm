package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/30 17:03
 */
public class caseOff039 {
    //ver moer vote
    public int majorityElement(int[] nums) {
        int sum = 0;
        int ans =0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(sum==0){
                ans = nums[i];
            }
            sum +=(ans == nums[i])?1:-1;
        }
        return ans;
    }
}
