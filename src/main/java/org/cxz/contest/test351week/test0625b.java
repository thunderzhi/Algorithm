package org.cxz.contest.test351week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/6/25 10:28
 */
public class test0625b {

    public int makeTheIntegerZero(int num1, int num2) {
        //num1 = num1 - (2^i+num2)
        //num1 = num1 - (2^i+num2)
        //X>=0
        // X*num2 + X 2^i ==? num1
        // X*num2 == num1 -  2^i-2^i2-2^i3
        // X*num2 == num1 -  Y
        // num2>0 num1 >0
        // if x exist num2<num1 num2>0 && x*num2 = 2^j

        // num2<0  num1 >0
        // if  num1-2^j < num2
        //
        //
        //  must find  2^i = X*num2
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
//System.out.println("i: "+i +" f "+f);
                if(Long.bitCount(f)<=i&&i<=f){
                    return (int)i;
                }
            }
        }
        return -1;
    }
}
