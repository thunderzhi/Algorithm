package org.cxz.contest.test2023354week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/16 10:27
 */
public class test0716a {
    public int sumOfSquares(int[] nums) {
        int n = nums.length,ans =0;
        for (int i = 0; i < n; i++) {
            if(n%(i+1)==0){
                ans += (nums[i]*nums[i]);
            }
        }
        return ans;



    }

}
