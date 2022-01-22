package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/22 17:22
 */
public class case1201 {

    public class Help{
        long a,b,c,ab,bc,ac,abc ;
        public Help(int _a,int _b,int _c ){
            a= _a;
            b= _b;
            c= _c;
            ac = lcm(a,c);
            ab = lcm(a,b);
            bc = lcm(b,c);
            abc = lcm(a,lcm(b,c));
        }

        public long gcd (long i,long j){
            if(j>0){
                return gcd(j,i%j);
            }
            return i;
        }

        public long lcm (long i,long j){
            return i*j/gcd(i,j);
        }

        public long getN(long n){
            return n/a+n/b+n/c - n/ab -n/bc -n/ac +n/abc;
        }
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        long l = 1;
        long r = (long)(n*Math.min(a,Math.min(b,c)));
        long mid = 0;
        Help help = new Help( a,b,c);
        while(l<r){
            mid = l+(r-l)/2;
            if((int)help.getN(mid)<n){//miss boundary 01
                l = mid+1 ;
            }
            else{
                r = mid;
            }
        }
        return (int)l;
    }
}
