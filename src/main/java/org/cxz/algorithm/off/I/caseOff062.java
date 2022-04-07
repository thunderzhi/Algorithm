package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/6 17:09
 */
public class caseOff062 {

    //ver1
    public int lastRemaining(int n, int m) {
        if(n<1||m<1) return -1;
        int ans =0;
        for(int i=2;i<=n;i++){
            ans = (ans+m)%i;
        }
        return ans;
    }

    //ver2
    public int lastRemaining2(int n, int m) {
        int[] d = new int[n+1];
        d[1]=0;
        /*
        d[i] = (d[i-1]+m)%i
         */
        if(n<1||m<1) return -1;
        for (int i = 2; i <=n ; i++) {
            d[i] = (d[i-1]+m)%i;
        }
        return d[n];
    }
}
