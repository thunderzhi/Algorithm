package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/19 18:27
 */
public class caseOff056_I {
    public int[] singleNumbers(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int i=0;i<n;i++){
            sum^=nums[i];
        }
        int ind =0;
        while((sum&(1<<ind))==0){
            ind++;
        }
        int[] ans = new int[2];
        int mark = (1<<ind);
        for(int i=0  ;i<n;i++){
            if((mark&nums[i])==0){
                ans[0]^=nums[i];
            }
            else{
                ans[1]^=nums[i];
            }
        }
        return ans;
    }
}
