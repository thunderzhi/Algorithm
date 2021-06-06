package org.cxz.algorithm.search;

import java.lang.annotation.Target;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/3 16:07
 */
public class case035 {
    public static void main(String[] args) {
        //[1,3,5,6], 5
        //[1,3,5,6], 2
        int[] a1 = new int[]{1,3,5,6};
        int[] a2 = new int[]{1};
        int t1 = 5;
        int t2 = 2;
        int t7 = 7;
        int t0 = 0;
        int t = 1;
        int res = new case035().searchInsert(a2, t);
        System.out.println("res = " + res);


    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length==0){
            return 0;
        }
        int l = 0 ; int r = nums.length-1;
        while (l<r){
            int mid = (l+r)>>1;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                r =mid -1;
            }
            else{
                l = mid +1;
            }
        }
        return l;
    }


}
