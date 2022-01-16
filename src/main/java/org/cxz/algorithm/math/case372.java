package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/16 23:59
 */
public class case372 {

    public int power(int a,int b,int m){
        int base = a%m;
        int ans =1;
        while(b>0){
            if((b&1)==1){
                ans = ans*base%m;
            }
            base = base*base%m;
            b>>=1;
        }
        return ans;
    }

    public int superPow(int a, int[] b) {
        int ans = 1;
        int base = a;
        int m = 1337;
        for(int i= b.length-1;i>=0;i--){
            ans = ans*power(base,b[i],m)%m;
            base = power(base,10,m);
        }
        return ans;
    }
}
