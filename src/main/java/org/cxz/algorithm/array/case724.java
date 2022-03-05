package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/5 16:10
 */
public class case724 {

    //ver 1 presum
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i=0;i<n;i++){
            sum[i+1]=sum[i]+nums[i];
        }
        //if(sum[n]-nums[0]==0) return 0;
        for(int i=0;i<n;i++){
            if(2*sum[i]+nums[i]==sum[n]) return i;
        }

        return -1;
    }

    // ver 2
    public int pivotIndex2(int[] nums) {
        int n = nums.length;
        int total = 0,sum=0;
        for(int i=0;i<n;i++) total += nums[i];
        for(int i=0;i<n;i++){
            if(2*sum+nums[i]==total) return i;
            sum +=nums[i];
        }
        return -1;
    }
}
