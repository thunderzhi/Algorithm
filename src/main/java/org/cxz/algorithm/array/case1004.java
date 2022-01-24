package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/24 23:37
 */
public class case1004 {

    public int longestOnes(int[] nums, int k) {
        int l=0,r =-1,cnt0=0,max =0;
        while(true){
            if(cnt0<=k){
                r = r+1;

                if(r==nums.length){
                    break;
                }
                if(nums[r]==0){
                    cnt0++;
                }
            }
            else{
                if(nums[l]==0){
                    cnt0--;
                }
                l=l+1;
            }
            if(cnt0<=k){
                max = Math.max(max,r-l+1);
            }
        }
        return max;
    }
}
