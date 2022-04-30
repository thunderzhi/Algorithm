package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/29 16:35
 */
public class case2216 {

    //ver 2 bymy greed
    public int minDeletion(int[] nums) {
        int cnt =0,pre=-1,n =nums.length;
        for(int i=0;i<nums.length;i++){
            if((cnt&1)==1&&pre==nums[i]){
                continue;
            }
            pre = nums[i];
            cnt++;
        }
        if((cnt&1)==1) cnt--;
        return n-cnt;
    }

    //ver 1 double cap
    public int minDeletion2(int[] nums) {
        int cnt =0,pre=nums[0],n =nums.length;
        for(int i=1;i<n;i++){
            if(pre==nums[i]){
                continue;
            }
            cnt++;
            if(i+1==n) break;
            pre = nums[i+1];
        }
        return n-cnt*2;
    }
}
