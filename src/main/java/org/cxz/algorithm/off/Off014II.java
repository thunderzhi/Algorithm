package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/7 21:53
 */
public class Off014II {
    public long mod = 1000000007;
    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        int m = n%3;
        int time = n/3;
        if(m == 0) return (int)pow(3,time);
        if(m == 1) return (int)((pow(3,time-1)*4)%mod);
        return (int)((pow(3,time)*2)%mod);
    }
    public long pow(int x,int n){
        long res = 1;
        int i =0;
        while(i<n){
            res = (res*x)%mod;
            i++;
        }
        return  res;
    }
}
