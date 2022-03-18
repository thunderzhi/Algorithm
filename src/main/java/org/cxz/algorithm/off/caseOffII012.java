package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/18 15:03
 */
public class caseOffII012 {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i =0;i<n;i++){
            sum[i+1] = sum[i]+nums[i];
        }
        int ind =-1;
        for(int i =0;i<n;i++){
            if(sum[i] == sum[n]-sum[i+1]){
                ind = i;
                break;
            }
        }
        return ind;
    }
}
