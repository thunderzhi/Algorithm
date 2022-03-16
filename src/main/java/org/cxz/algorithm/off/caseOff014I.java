package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/15 22:21
 */
public class caseOff014I {


    public int cuttingRope(int n) {
        //n==2   --1
        //n==3   --2
        if(n<=3) return n-1;
        int m = n%3;
        int q = n/3;
        if(m==0) return pow(3,q);
        if(m==1) return pow(3,q-1)*4;
        return pow(3,q)*2;
    }

    public int pow(int x,int n){
        int res = 1;
        while(n>0){
            if((n&1)==1) res *=x;
            x *=x;
            n>>>=1;
        }
        return res;
    }
}
