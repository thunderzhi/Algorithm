package org.cxz.contest.test1106;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/11/6 10:30
 */
public class test1106a {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n-1 ; i++) {
            if(nums[i]!=nums[i+1]){
                continue;
            }
            nums[i] = nums[i]*2;
            nums[i+1] = 0;
        }
        int[] ans = new int[n];
        int p = 0, ind =0;
        while(p<n){
            if(nums[p]!=0){
                ans[ind++] = nums[p];
            }
            p++;
        }
        return ans;

    }
}
