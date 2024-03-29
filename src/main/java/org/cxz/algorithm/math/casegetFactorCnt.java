package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/8/30 21:36
 */
public class casegetFactorCnt {
    public static void main(String[] args) {

        long res = getFactorCnt(25,5);
        System.out.println("res = " + res);

    }
    //get x factor counts in n! x>1,n>0
    public static long getFactorCnt(int n,int x){
        long ans = 0;
        while(n!=0){
            ans += n/x;
            n/=x;
        }
        return ans;
    }
}
