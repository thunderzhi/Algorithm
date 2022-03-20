package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/20 16:02
 */
public class casdOffII003 {

    // ver1 brute
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i] = getCnt(i);
        }
        return ans;
    }

    public int getCnt(int n){
        int cnt =0;
        while(n>0){
            if((n&1)==1) cnt++;
            n>>>=1;
        }
        return cnt;
    }



}
