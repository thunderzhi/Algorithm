package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/9 21:14
 */
public class case324 {

    // ver 1
    public void wiggleSort1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] t = new int[n];
        int j = n - 1;
        for(int i = 1; i < n; i+=2 , j--){
            t[i] = nums[j];
        }
        for(int i = 0; i < n; i+=2 , j--){
            t[i] = nums[j];
        }
        for(int i = 0;i < n;i++){
            nums[i] = t[i];
        }
    }
}
