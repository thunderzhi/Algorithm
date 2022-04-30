package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/29 10:53
 */
public class case1101 {

    //ver 1 binary cap
    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r= 0,mid;
        for(int x :weights){
            r +=x;
            l = Math.max(l,x);
        }
        while(l<r){
            mid = l+(r-l)/2;
            if(check(weights,mid)<=days){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }

    public int check(int[] nums ,int limit){
        int cnt = 1, sum =0;
        for(int n:nums){
            if(sum + n>limit){
                cnt++;
                sum = n;//miss
            }
            else{
                sum += n;
            }
        }
        return cnt;
    }
}
