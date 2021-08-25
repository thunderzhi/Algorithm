package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/16 17:05
 */
public class case283 {

    public static void main(String[] args) {
        //[0,1,0,3,12]
        int[] ints = {1,0,1};
        new case283().moveZeroes(ints);
    }

    public void moveZeroes(int[] nums) {
        if (nums.length==0){
            return;
        }
        //p++ until nums[p]==0
        int p=0,q =0;
        int n = nums.length;

        while (q<n){
            if(nums[q]!=0){
                if (p!=q){
                    nums[p] = nums[q];
                    nums[q] = 0;
                    //swap(nums,p,q);
                }

                p++;
            }
            q++;

        }

        System.out.println("nums = " + Arrays.toString(nums));
    }

    private void swap(int[] a ,int i,int j){
        int b = a[i];
        a[i] = a[j];
        a[j] = b;
    }

}
