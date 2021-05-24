package org.cxz.algorithm.array;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/22 19:16
 */
public class case075 {
    public static void main(String[] args) {
        int[] a = new int[]{2,0,1};
        new case075().sortColors(a);

        System.out.println("Arrays.asList(a) = " + Arrays.toString(a));


    }

    public void sortColors(int[] nums) {
        qs(nums,0, nums.length-1,1);
    }

    public void qs(int[] nums,int left ,int right,int mid){
        int p = left;
        int q = right+1;
        int i=p;
        while(i<q){
            if(nums[i]==mid){
                i++;
            }else if(nums[i]<mid){
                swap(nums,p,i);
                p++;
                i++;
            }else {
                q--;
                swap(nums,q,i);
            }
        }
    }

    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
