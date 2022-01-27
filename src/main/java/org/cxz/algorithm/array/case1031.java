package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/27 15:11
 */
public class case1031 {


    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] lmax = new int[n + 1];
        int[] mmax = new int[n + 1];
        int lsum = 0;
        int msum = 0;
        for(int i = n-1;i>=0;i--){
            lsum += nums[i];
            msum += nums[i];
            if(i+firstLen<n){
                lsum -= nums[i+firstLen];
            }
            if(i+secondLen<n){
                msum -= nums[i+secondLen];
            }
            if(i+firstLen<=n){lmax[i] = Math.max(lsum,lmax[i+1]);}
            if(i+secondLen<=n){mmax[i] = Math.max(msum,mmax[i+1]);}
        }
        int ans =0;
        lsum =0;
        msum = 0;
        for(int i = 0; i<n ;i++){
            lsum += nums[i];
            msum += nums[i];
            if(i-firstLen>=0){
                lsum -= nums[i-firstLen];
            }
            if(i-secondLen>=0){
                msum -= nums[i-secondLen];
            }
            ans = Math.max(ans, lsum + mmax[i+1]);
            ans = Math.max(ans, msum + lmax[i+1]);
        }
        return ans;
    }

}
