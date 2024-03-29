package org.cxz.contest.test2023353week;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/8 22:29
 */
public class test0709d {

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
