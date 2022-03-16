package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/16 11:46
 */
public class caseOff053II {

    //ver 1 On
    public int missingNumber(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            if(i == nums[i]) continue;
            return i;
        }
        return nums.length ;
    }
}
