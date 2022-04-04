package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/3 21:30
 */
public class caseOff015 {
    public int hammingWeight(int n) {
        int cnt =0;
        while(n!=0){
            n = (n&(n-1));
            cnt++;
        }
        return cnt;
    }
}
