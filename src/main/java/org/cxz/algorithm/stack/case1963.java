package org.cxz.algorithm.stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/13 12:29
 */
public class case1963 {

    public int minSwaps(String s) {
        int len = s.length();
        int l = 0,r = len-1;
        int cntL = (s.charAt(l)=='[')?1:-1;
        int cntR = (s.charAt(r)==']')?1:-1;
        int ans=0;
        while(l<r){
            while(l<r&&cntL>=0){
                l++;
                cntL += (s.charAt(l)=='[')?1:-1;
            }
            while(l<r&&cntR>=0){
                r--;
                cntR += (s.charAt(r)==']')?1:-1;
            }
            if(l>=r) break;
            ans++;
            cntL+=2;
            cntR+=2;
        }
        return ans;
    }
}
