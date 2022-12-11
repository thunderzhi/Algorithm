package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/11 16:56
 */
public class case396 {

    // update replace array
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        //int[] f = new int[n];
        int f0 =0;
        int[] sum = new int[n+1];
        for(int i=0;i<n ;i++){
            sum[i+1] = sum[i]+ nums[i];
            f0 += i*nums[i];
        }
        int ans = f0,pre = f0,cur = f0;
        for(int i=1;i<n ;i++){
            //f[n-1] = f[n-2] - (n-1)*f[1] + sum[n] - x[1]
            cur = pre - n*nums[n-i] + sum[n];
            ans = Math.max(ans,cur);
            pre = cur;
        }
        return ans;
    }
}
