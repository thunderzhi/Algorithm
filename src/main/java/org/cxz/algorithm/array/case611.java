package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/20 16:34
 */
public class case611 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,3,4};
        int i = new case611().triangleNumber(arr);
        System.out.println("i = " + i);

    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        // a+b>c
        // a-b<c
        int n = nums.length;
        int ans =0;
        for (int i = 0; i < n-2 ; i++) {
            for (int j =i+1; j < n - 1; j++) {
                int x = nums[i]+nums[j];
                int left = j+1;
                int right = n-1;
                int first = find01(nums,left,right,x);
                ans += first-1-j;
            }
        }
        return ans;
    }

    // find first bigger than tar
    public int find01(int[] arr ,int left,int right,int tar){
        int l = left;
        int r = right;
        int mid = 0;
        while(r-l>3){
            mid = l+(r-l)>>1;
            if (arr[mid]<tar) {
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        for (int i = l; i <=r; i++) {
            if(arr[i]>=tar){
                return i;
            }
        }
        return arr.length;
    }

}
