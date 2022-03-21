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


    //ver 2 On
    public int[] countBits2(int n) {
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            if((i&1)==0){
                ans[i] = ans[i/2];
            }
            else{
                ans[i] = ans[i-1]+1;
            }

        }
        return ans;
    }
    //ver 2 On
    public int[] countBits22(int n) {
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i] = (i&1)==0?ans[i/2]:ans[i-1]+1;
        }
        return ans;
    }
}
