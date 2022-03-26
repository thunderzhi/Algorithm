package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/26 18:01
 */
public class caseOff043 {

    //ver1 math hard
    public int countDigitOne(int n) {
        int num = n;
        int ans = 0;
        long k = 1;
        for(int i = 0;k<=n;i++){
            ans += (num/(10*k))*(k)+ Math.min(k,Math.max(0,(num%(10*k)-k+1)));
            k*=10;
        }
        return  ans;
    }
}
