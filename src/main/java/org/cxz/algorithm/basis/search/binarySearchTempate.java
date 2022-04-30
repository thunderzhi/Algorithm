package org.cxz.algorithm.basis.search;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/24 15:25
 */
public class binarySearchTempate {
    /* base binarysearch if target exist return index,else return -1
       */
    public int base_BinarySearch(int[] nums,int tar){
        int l =0,r = nums.length-1,mid;
        while(l<=r){
            mid = l+ (r-l)/2;
            if(nums[mid]==tar) return mid;
            if(nums[mid]<tar) l = mid+1;
            else r = mid-1;
        }
        return -1;
    }
    /*
    * base find first 1,if its exist return it index,
    * else return 0,OR N
    *  */
    public int find01(int[] nums,int tar){
        int l =0,r = nums.length-1,mid;
        while(l<r){
            mid = l+ (r-l)/2;
            if(nums[mid]<tar) l = mid+1;
            else r = mid;
        }
        if(nums[l]>=tar) return l;
        return l+1;//nums.length
    }



}
