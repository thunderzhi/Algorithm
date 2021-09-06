package org.cxz.algorithm.search;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/25 16:22
 */
public class case081 {
    public static void main(String[] args) {

    }

    public boolean search(int[] nums, int target) {
        if(nums[0]==target||nums[nums.length-1]==target){
            return true;
        }
        int l = 0;
        int r = nums.length -1;
        int mid,head,tail;
        while(l<nums.length&&nums[l]==nums[0]){
            ++l;
        }
        while(r>=0&&nums[r]==nums[0]){
            --r;
        }
        head = l;
        tail = r;
        while(l<=r){
            mid= (l+r)>>1;
            if(nums[mid]==target){
                return true;
            }
            if (nums[mid]<=nums[tail]){
                if (nums[mid]<target&&target<=nums[tail]){
                    l = mid+1;
                }
                else{
                    r = mid -1;
                }
            }
            else{
                if (nums[mid]>target&&nums[head]<=target){
                    r = mid-1;
                }
                else{
                    l = mid +1;
                }
            }

        }
        return false;
    }

}
