package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/26 14:26
 */
public class case2520 {
    public int countDigits(int num) {
        int cnt = 0,x = num;
        while(x>0){
            int m = x%10;
            // if(m>0&& (num%m==0)) cnt++;
            if(num%m==0) cnt++;
            x/=10;
        }
        return cnt;
    }
}
