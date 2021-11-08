package org.cxz.algorithm.bit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/8 11:04
 */
public class case190 {
    public static void main(String[] args) {

    }

    public int reverseBits(int n) {
        int res=0;
        for (int i = 0,j=1,k=(1<<31); i <32 ;i++,j=j<<1,k=k>>>1) {
            if((n&j)!=0){
                res|=k;
            }
        }
        return  res;
    }
}
