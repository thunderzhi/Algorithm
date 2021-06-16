package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/16 17:05
 */
public class case283 {

    public static void main(String[] args) {
        //[0,1,0,3,12]
    }

    public void moveZeroes(int[] nums) {
        if (nums.length==0){
            return;
        }
        int p=0,q =0;
        int length = nums.length;
        q = p+1;
        while(q<length){
            if(nums[q]==0){
                q++;
                continue;
            }
            if(nums[p]==0&&nums[q]!=0){
                nums[p] = nums[q];
                nums[q] =0;
                p = q;
                q++;
                continue;
            }
            if(nums[p]!=0){
                p++;
            }
        }

    }

}
