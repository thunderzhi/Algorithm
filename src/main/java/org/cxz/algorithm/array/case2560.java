package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/19 15:00
 */
public class case2560 {
    public int minCapability(int[] nums, int k) {
        //
        int n = nums.length;
        int l = 0, r = 1<<30,mid = 0;
        for(int x:nums) r = Math.max(r,x);
        while(l<r){
            mid = l+ (r -l)/2;
            if(most(nums,mid)>=k){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }

    public int most(int[] arr,int money){
        int n = arr.length;
        int[][] f = new int[n+1][2];
        f[1][0] = 0;
        f[1][1] = arr[0]>money?0:1;
        for(int i = 2;i<=n;i++){
            f[i][0] = Math.max(f[i-1][0],f[i-1][1]);
            if(arr[i-1]>money){
                f[i][1] = f[i][0];
            }
            else{
                f[i][1] = f[i-1][0]+1;
            }
        }
        return Math.max(f[n][0],f[n][1]);
    }
}
