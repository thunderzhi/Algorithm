package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/17 23:23
 */
public class case268 {

    //异或
    public int missingNumber1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n^=i;
            n^=nums[i];
        }
        return n;
    }

    //sort by num[i]==i
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i && nums[i] < n) swap(nums, nums[i], i--);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) return i;
        }
        return n;
    }
    void swap(int[] nums, int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }

    public int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=i) return i;
        }
        return nums.length;
    }
}
