package org.cxz.algorithm.off.I;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/21 11:28
 */
public class caseOff061 {

    //ver 1 O1 nlogn
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int cnt0 =0;
        for(int i =0;i<5;i++){
            if(nums[i]==0) cnt0++;
            if(nums[i]>0&&i<4){
                if(nums[i+1]==nums[i]) return false;
                if(nums[i+1]-nums[i]>1&&nums[i+1]-nums[i]-1>cnt0) return false;
                cnt0 -=nums[i+1]-nums[i]-1;
            }
        }

        return true;
    }
}
