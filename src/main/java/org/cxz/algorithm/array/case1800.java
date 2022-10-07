package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/10/7 15:31
 */
public class case1800 {

    public int maxAscendingSum(int[] nums) {
        int n = nums.length, ans = 0;
        int sum = nums[0],pre = nums[0];
        for(int i= 1;i<n;i++){
            if(nums[i]>nums[i-1]){
                sum +=nums[i];
                continue;
            }
            ans = Math.max(ans,sum);
            sum = nums[i];
        }
        ans = Math.max(ans,sum);
        return ans;
    }
}
