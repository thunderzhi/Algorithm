package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: fast pow ,X^n   O(logN)
 * @date 2022/3/11 12:52
 */
public class fastpow {
    //X^n
    long binpow(  long x,   long n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1)==1) res = res * x;
            x = x * x;
            n >>>= 1;
        }
        return res;
    }

    // X^n mod M
    long binpowMod(  long x,  long n, long m) {
        x %= m;
        long res = 1;
        while (n > 0) {
            if ((n & 1)==1) res = res * x % m;
            x = x * x % m;
            n >>>= 1;
        }
        return res;
    }


}
