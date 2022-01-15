package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/15 15:37
 */
public class gcdcase {

    int gcd(int a,int b){
        if(b>0){
            return gcd(b,a%b);
        }
        System.out.println("a = " + a);
        return a;
    }

}
