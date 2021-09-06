package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/4 18:55
 */
public class case189 {

    public static void main(String[] args) {

    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k%n);
        reverse(nums,k%n+1,nums.length-1);
    }

    public void reverse(int[] nums,int l ,int r){
        while(l<r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
