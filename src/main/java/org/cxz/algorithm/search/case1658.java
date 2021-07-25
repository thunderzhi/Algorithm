package org.cxz.algorithm.search;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/22 13:57
 */
public class case1658 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,7,8,9};
       int ans  = new case1658().minOperations(arr,4);
        System.out.println("ans = " + ans);
    }

    public int minOperations(int[] nums, int x) {
        int[] presuml = new int[nums.length+1];
        int[] presumr = new int[nums.length+1];
        presuml[0] =0;
        presumr[0] =0;

        for (int i = 0; i < nums.length; i++) {
            presuml[i+1] = presuml[i]+nums[i];//calc presum from left
        }

        System.out.println("Arrays.toString(presuml) = " + Arrays.toString(presuml));
        for (int i = nums.length-1; i >=0 ; i--) {
            presumr[nums.length-i] = presumr[nums.length-i-1] + nums[i];//calc presum from right
        }
        System.out.println("Arrays.toString(presumr) = " + Arrays.toString(presumr));
        int ans = -1;
        //travel from left presum ,then try to find a result equal (x-presuml[i]) from right presum
        //if exist should return j
        //(i+j) maybe the result but we should check i+j bigger than length
        //if ans is bigger than (i+j),we shoule replace ans with (i+j)
        for (int i = 0; i < presuml.length; i++) {
            int j = binarysearch(presumr, x - presuml[i]);
            if(j==-1){
                continue;
            }
            if(i+j>nums.length){
                continue;
            }
            if(ans==-1||ans>(i+j)){
                ans = i+j;
            }
        }
        return ans;
    }

    public int binarysearch(int[] arr,int x){
        int head  =0 ;
        int tail = arr.length-1;
        int mid = 0;
        while (head<=tail){
            mid = (head+tail)>>1;
            if (arr[mid] == x) {
                return mid;
            }
            else if (arr[mid]<x){
                head = mid+1;
            }
            else{
                tail = mid -1;
            }
        }

        return -1;
    }
}
