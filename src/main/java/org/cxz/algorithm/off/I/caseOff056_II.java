package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/19 18:27
 */
public class caseOff056_II {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        int n = nums.length;
        for(int x :nums){
            for(int i=0;x>0&&i<bit.length;i++){
                if((x&1)==1){
                    bit[i]++;
                }
                x>>>=1;
            }
        }
        int ans =0;
        for(int i = 0;i<bit.length;i++){
            bit[i] %=3;
            if(bit[i]!=0){
                ans = ans+ (1<<i);
            }
        }
        return ans;
    }
}
