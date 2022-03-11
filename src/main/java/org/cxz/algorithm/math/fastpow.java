package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: fast pow ,X^n   O(logN)
 * @date 2022/3/11 12:52
 */
public class fastpow {

    long binpow(  long x,   long n) {
        long res = 1;
        while (n > 0) {
            if (n & 1) res = res * x;
            x = x * x;
            n >>= 1;
        }
        return res;
    }
}
