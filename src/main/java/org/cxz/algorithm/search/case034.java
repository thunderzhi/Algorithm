package org.cxz.algorithm.search;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/3 17:02
 */
public class case034 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        int[] ints = new case034().searchRange(arr, 6);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        int pos = 0;
        int first = searchfirst01(nums,pos, target);
        if(first==nums.length||nums[first]!=target){
            return ans;
        }
        pos = first;
        int last = searchfirst01(nums, pos,target+1)-1;
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
    public int searchfirst01(int[] arr,int pos, int target){
        if(arr.length==0){
            return -1;
        }
        int l = pos ;
        int r = arr.length-1;
        int mid = 0;
        while (r-l>3){
            mid = (l+r)>>1;
            if(arr[mid]>=target){
                r = mid;
            }
            else{
                l =mid+1;
            }
        }
        for (int i = l; i <=r ; i++) {
            if (arr[i]>=target){
                return i;
            }
        }
        return arr.length;
    }

    public int searchlast(int[] arr,int pos, int target){
        int l = pos ;
        int r = arr.length-1;
        int mid = 0;
        while (l <r){
            mid = (l+r+1)>>1;
            if(arr[mid]>target){
                r = mid-1;
            }
            else{
                l = mid;
            }
        }
        return arr[l]!= target?-1:l;
    }
}
