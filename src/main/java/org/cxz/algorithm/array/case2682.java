package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/16 11:24
 */
public class case2682 {
    public int[] circularGameLosers(int n, int k) {
        //
        boolean[] mark = new boolean[n];
        int r = 0;
        for(int i = 0;!mark[i];i =(i+r*k)%n){
            mark[i] = true;
            r++;
        }
        int[] ans = new int[n-r];
        for(int i=0,j=0;i<n;i++){
            if(!mark[i]) ans[j++]= i+1;
        }
        return ans;
    }
}
