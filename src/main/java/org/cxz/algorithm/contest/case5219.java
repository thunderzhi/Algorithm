package org.cxz.algorithm.contest;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/3 11:10
 */
public class case5219 {

    public static void main(String[] args) {

    }
    // not pass
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        long n = candies.length;
        long total = 0;
        for(int candie: candies){
            total += (long)(candie);
        }
        long sum = (long)(candies[0])*k;
        if(n >= k){
//            return total>=sum?candies[(int)(n-k)]:0;
            return candies[(int)(n-k)];
        }
        long max = total/k;
        long diff = k-n;
        int ans = (int)getcandiecnt(candies,max,diff);
        return ans;
    }
    public long getcandiecnt(int[]nums,long max,long diff){
        long l =0,r = max;
        long mid= 0;
        while(l<r){
            mid = l+(r-l)/2;
            if(can(nums,mid,diff)){
                l = mid;
            }
            else{
                r = mid-1;
            }
        }
        return l ;
    }

    public boolean can(int[]nums,long max,long diff){
        int cnt = getcnt(nums,0,nums.length-1,max);
        return cnt>=diff?true:false;
    }

    public int getcnt(int[] num,int l ,int r,long tar){
        if(l>r) return 0;
        if(l==r&&num[l]==tar*2) return 1;
        int mid =0;
        while(l<r){
            mid = l+(r-l)/2;
            if(num[mid]>= 2*tar){
                r = mid;
            }
            else{
                l= mid+1;
            }
        }
        if(l==r&&num[l]!=tar*2) return 0;
        return r-l+1;
    }

}
