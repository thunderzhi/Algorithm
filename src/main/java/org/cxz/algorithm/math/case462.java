package org.cxz.algorithm.math;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/29 13:43
 */
public class case462 {
    public static void main(String[] args) {

    }
    //find median
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int cnt = 0;
        //common
        while (i<j){
            cnt += nums[j--]-nums[i--];
        }
        return cnt;
    }

    public int minMoves22(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int cnt = 0;
        int mid = (nums.length-1)>>1;
        for (int k = 0; k < nums.length; k++) {
            cnt += Math.abs(nums[k]-nums[mid]);
        }
        return cnt;

    }
}
