package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/2/25 11:09
 */
public class case2401 {
    public int longestNiceSubarray(int[] nums) {
        int ans =1,diff=0,n = nums.length,left =0;
        int mask = 0;
        for(int i =0;i<n;){
            int x = nums[i];
            if((mask&x)==0){
                if(ans<i-left+1){
// System.out.println(" i: "+i+ " left: "+left);
                    ans = i-left+1;
                }
            }
            i++;
            while((mask&x)!=0&&left<i){
                mask ^= nums[left];
                left++;
            }
            mask |=x;
        }
        return ans;
    }
}
