package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/8 23:57
 */
public class case1749 {


    public int maxAbsoluteSum(int[] nums) {
        int s = 0, mx = 0, mn = 0;
        for (int x : nums) {
            s += x;
            mx = Math.max(mx, s);
            mn = Math.min(mn, s);
            //if (s > mx) mx = s;
            //else if (s < mn) mn = s; // 效率更高的写法
        }
        return mx - mn;
    }

    public int maxAbsoluteSum2(int[] nums) {
        int n = nums.length, ans = nums[0];
        int premax = 0,premin = 0;
        int sum = 0 ;
        for(int i = 0;i<n;i++){
            sum += nums[i];
            int a = sum - premin;
            int b = premax -sum; 
            ans = Math.max(ans,Math.max(b,a));

            premin = Math.min(sum,premin);
            premax = Math.max(sum,premax);
        }
        return ans;
    }
}
