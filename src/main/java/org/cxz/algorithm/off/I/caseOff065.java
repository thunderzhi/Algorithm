package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/1 23:44
 */
public class caseOff065 {
    public int add(int a, int b) {
        int c = 0;
        while(b!=0){
            c = (a^b);
            b = (a&b)<<1;
            a = c;
        }
        return a;
    }
}
