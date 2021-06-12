package org.cxz.algorithm.array;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/12 16:07
 */
public class case053 {
    public static void main(String[] args) {
        int[] a = new int[]{-2,-1};
        //0,5,9,8,15,23
        //0|5,5,5,5,5
        //0|5,4,
        //-2,-1

        int i = new case053().maxSubArray(a);
        System.out.println("i = " + i);
    }


    public int maxSubArray(int[] nums) {

        int min = 0;
        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(ans,sum-min  );

            min = Math.min(sum,min);
        }

        return ans;
    }



}
