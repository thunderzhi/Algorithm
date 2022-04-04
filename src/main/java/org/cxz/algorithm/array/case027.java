package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/3 21:28
 */
public class case027 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int cnt=0;
        for(int num :nums){
            if(num==val) cnt++;
        }
        if(cnt==0) return n;
        int p=0,q=n-1;
        while(p<q&&nums[p]!=val){p++;}
        int base = nums[p];
        while(p<q){
            while(p<q&&nums[q]==val) q--;
            if(p<q){
                nums[p++] = nums[q--];
            }
            while(p<q&&nums[p]!=val) p++;
        }
        if(p==q){
            return nums[p]==val?p:p+1;
        }
        return p;

    }
}
