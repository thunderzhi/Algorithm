package org.cxz.algorithm.off.II;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/14 12:54
 */
public class caseOffII001 {
    public int divide(int a, int b) {
        int ans =0;
        if(a==0||b==0) return 0;
        //System.out.println("min: "+Integer.MIN_VALUE);
        if(a==Integer.MIN_VALUE&&b ==-1) return Integer.MAX_VALUE;
        if(a==b) return 1;
        if(b==Integer.MIN_VALUE) return 0;
        int negative = -1;
        if((a<0&&b<0)||(a>0&&b>0)) negative =1;
        int dividend = a>0?-a:a;
        int divisor = b>0?-b:b;
        while(dividend<=divisor){
            int value =divisor;
            int quotient =1;
            while(dividend<=(value+value)&&(Integer.MIN_VALUE>>1)<=value){
                quotient += quotient;
                value += value;
            }
            dividend -= value;
            ans += quotient;
        }
        return negative==-1? -ans:ans;
    }
}
