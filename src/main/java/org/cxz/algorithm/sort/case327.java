package org.cxz.algorithm.sort;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/8 16:44
 */
public class case327 {
    public static void main(String[] args) {
        //[-2,5,-]

        /*
        [2147483647,-2147483648,-1,0]
-1
0
[-2147483647,0,-2147483647,2147483647]
-564
3864
         */
        int[] a = new int[]{-2147483647,0,-2147483647,2147483647};
        int i = new case327().countRangeSum(a, -564, 3864);
        System.out.println("i = " + i);

    }
    private long[] temp;
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] presum = new long[nums.length+1];//first is 0
        temp = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            presum[i+1]=presum[i]+nums[i];
        }
        return mergesort(presum,0,presum.length-1,lower,upper);
    }
    /*
       lower ,upper is bound
     */
    public int mergesort(long[] presum,int l,int r ,int lower, int upper){
        if(l>=r){
            return 0;
        }
        int mid = (l+r)>>1;
        int ans= 0;
        ans += mergesort(presum,l,mid,lower,upper);
        ans += mergesort(presum,mid+1,r,lower,upper);
        ans += counttwopart(presum,l,mid,mid+1,r,lower,upper);
        int k = l ,p1 = l, p2 = mid+1;
        while (p1<=mid||p2<=r){
            if((p2>r)||(p1<=mid&&presum[p1]<= presum[p2])){
                temp[k++]= presum[p1++];
            }
            else{
                temp[k++]= presum[p2++];
            }
        }
        for (int i =l; i <=r; i++) {
            presum[i] = temp[i];
        }
        return ans;
    }

    public int counttwopart(long[] sum,int l1,int r1,int l2,int r2,int lower,int upper){
        int ans =0 ,k1 = l1,k2 =l1;
        //Sum(j)-upper<=Sum(i)<=Sum(j)-lower
        for (int j = l2; j <=r2 ; j++) {
            long a = sum[j] - upper;
            long b = sum[j] - lower;
            while (k1<=r1&&sum[k1]<a){
                k1++;
            }//k1 is first bigger than a OR equal
            while (k2<=r1&&sum[k2]<=b){
                k2++;
            }//k2  is first bigger than b
            ans += k2 -k1;

        }
        return  ans;
    }

}
