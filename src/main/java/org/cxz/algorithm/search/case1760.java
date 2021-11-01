package org.cxz.algorithm.search;

import java.awt.font.NumericShaper;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/1 0:15
 */
public class case1760 {
    public static void main(String[] args) {

    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l =1,r=0;
        for(int x :nums){
            r = Math.max(r,x);
        }
        return bs(nums,l,r,maxOperations);
    }
    public int bs(int[] nums,int l,int r ,int n){
        if(l==r){
            return l;
        }
        int mid = (l+r)>>1;
        if(fu(nums,mid)<=n){
            r= mid;
        }
        else{
            l=mid+1;
        }
        return bs(nums,l,r,n);
    }
    // nums is array
    // x is every package should have max ball
    // this function return a value that means if each package have ball
    // not bigger than X,every element in array should split times
    public  int fu(int[] nums,int x){
        int cnt =0;
        for (int i = 0; i < nums.length; i++) {
            cnt += nums[i]/x + (nums[i]%x!=0?1:0) -1;
        }
        return cnt;
    }


}
