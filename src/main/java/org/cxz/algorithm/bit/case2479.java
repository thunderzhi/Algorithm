package org.cxz.algorithm.bit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/4 18:37
 */
public class case2479 {
    public int makeTheIntegerZero(int num1, int num2) {
        if(num1==num2) return -1;
        if(num2>0){
            for(int i = 1;num1-num2*i>0;i++){
                long f = num1-num2*i;
                if(Long.bitCount(f)<=i&&i<=f){
                    return i;
                }
            }
        }
        else{
            // num2<0
            for(long i = 1;i<40;i++){
                long f = (long)(num1*1L-num2*i*1L);
                if(Long.bitCount(f)<=i&&i<=f){
                    return (int)i;
                }
            }
        }
        return -1;
    }
}
