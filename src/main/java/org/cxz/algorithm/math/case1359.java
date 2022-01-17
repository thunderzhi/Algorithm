package org.cxz.algorithm.math;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/17 15:18
 */
public class case1359 {


    public int countOrders(int n) {
        //f(n) = (2(n^2)-n)*f(n-1)
        long mod = (long)(1e9+7);
        if(n==1) return 1;
        long[] f = new long[2];
        f[1]=1;
        for (int i = 2; i <=n ; i++) {
            int ind = i%2;
            int preind = ind==1?0:1;
            f[ind] = (2*i*i-i)*f[preind]%mod;
        }
        return (int)f[n%2];
    }
}
