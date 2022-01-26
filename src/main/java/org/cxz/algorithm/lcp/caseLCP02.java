package org.cxz.algorithm.lcp;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/26 17:05
 */
public class caseLCP02 {
    public int[] fraction(int[] cont) {
        int fenzi = 1;
        int fenmu = 0;
        int t  =0;
        for(int i = cont.length-1;i>=0;i--){
            t = fenzi;
            fenzi = fenmu;
            fenmu = t;

            fenzi = (cont[i]*fenmu+ fenzi);
            int r = gcd(fenmu,fenzi);
            fenzi /=r;
            fenmu /=r;
        }
        return new int[]{ fenzi,fenmu };
    }

    public int gcd(int a ,int b){
        if(b>0) return gcd(b,a%b);
        return a;
    }
}
