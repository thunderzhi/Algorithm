package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/10 18:44
 */
public class case35 {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int l = 0 ; int r = nums.length-1;
        while (l<=r){
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
