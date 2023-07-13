package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/13 15:46
 */
public class case2772 {
    public boolean checkArray(int[] nums, int k) {
        int sum =0, n = nums.length;
        int[] diff = new int[n+2];
        for(int i =0;i<n;i++){
            sum +=diff[i];
            if(nums[i]-sum<0) return false;
            //nums[i]-sum>=0
            if(nums[i]-sum==0) continue;
            if(nums[i]-sum>0){
                if(i>n-k) return false;
                //k = n - i
                int x = nums[i]-sum;
                diff[i]+=x;
                if(i+k<=n)diff[i+k]-=x;
                sum = nums[i];
            }
        }
        return true;
    }
}
