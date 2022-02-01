package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/1 11:25
 */
public class case2119 {

    public boolean isSameAfterReversals(int num) {
        if(num==0){
            return true;
        }
        if(num%10==0){
            return false;
        }
        int ans = reverse(reverse(num));
        return ans == num;
    }

    public int reverse(int num){
        int ans =0;
        while(num>0){
            int m = num%10;
            num = num/10;
            ans = ans*10+m;
        }
        return ans;
    }
}
