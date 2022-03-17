package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/16 17:09
 */
public class caseOff016 {

    //ver 1  int n maybe overflow
    public double myPow(double x, int n) {
        double ans = 0;
        if(n==0) return 1.0;
        long b = n;
        if(b<0){
            x = 1/x;
            b *=-1;
        }
        ans = fastpow(x,b);
        return ans;
    }

    public double fastpow(double x,long n){
        if(n==0) return 1.0;
        double res = 1.0;
        while(n>0){
            if((n&1)==1) res *= x;
            x *= x;
            n >>>=1;
        }
        return res;
    }
}
