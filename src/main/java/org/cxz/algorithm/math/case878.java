package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/16 16:47
 */
public class case878 {

    public long mod =(long)(1e9+7);
    public int nthMagicalNumber(int n, int a, int b) {
        long l =(long) Math.min(a,b);

        long r =(long)(n*l);

        long mid = 0;
        while(l<r){
            mid =l+(r-l)/2;
            if(f(mid,a,b)>=n){
                r = mid;
            }
            else{
                l =mid+1;
            }

        }
        return (int)(l%mod);

    }

    public long gcd(long a ,long b){
        if(b>0 ){
            return gcd(b,a%b);
        }
        return a;
    }

    public long lcm(long a ,long b){
        long m = (a*b);
        return (long)(m/gcd(a,b));
    }

    public long f(long n,long a,long b){
        return n/a+n/b- (n/lcm(a,b));
    }
}
