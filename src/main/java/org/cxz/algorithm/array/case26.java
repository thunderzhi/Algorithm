package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/15 15:25
 */
public class case26 {
    public static void main(String[] args) {


    }

    public int removeDuplicates(int[] nums) {
        int p =0 ;int q =p+1;
        int length = nums.length;
        if(length==1){
            return 1;
        }
        while(q<length){
            if(nums[p]==nums[q]){
                q++;
                continue;
            }
            nums[p+1]=nums[q];
            p++;
            q++;
        }
        return p+1;

    }
}
