package org.cxz.algorithm.bit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/28 15:53
 */
public class case693 {
    //ver1 bit
    public boolean hasAlternatingBits(int n) {
        while(n>0){
            if(((n&1)^((n>>1)&1))==0) return false;
            n>>>=1;
        }
        return true;
    }

    // ver2 bit
    public boolean hasAlternatingBits2(int n) {
        int a = (n^(n>>>1));
        return (a&(a+1))==0;
    }
}
