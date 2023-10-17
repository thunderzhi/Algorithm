package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/17 9:49
 */
public class case2625 {
    public long gcd(long a,long b){
        return b==0?a:( gcd(b,a%b));
    }

    public long lcm(long a,long b){
        return a*b/gcd(a,b);
    }

    public long Sum(long x,long n){
        long cnt = n/x;
        long s = (x+x*cnt)*cnt/2;
        return s;
    }

    public int sumOfMultiples(int n) {
        long x = (long)n; 
        long s3 = Sum(3,x), s5 = Sum(5,x),s7= Sum(7,x);
        long s35 = Sum(lcm(3,5),x), s57 = Sum(lcm(5,7),x),s37=Sum(lcm(3,7),x);
        long l = lcm(7,lcm(3,5));
        long s357 = Sum(l,x);
        long ans = s3+s5+s7-s35-s57-s37+s357;

        // System.out.println(" l "+l+" c3 "+cnt3+" c5 "+cnt5+" c7 "+cnt7);
        // long comm = x/l;
        // System.out.println(" comm "+comm);
        return (int)ans;
    }
}
