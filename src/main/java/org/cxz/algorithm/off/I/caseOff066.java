package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/5 11:49
 */
public class caseOff066 {
    // ver1 bymy
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] post = new int[n+1];
        post[n] =1;
        for(int i = n-1;i>=0;i--){
            post[i] = post[i+1]*a[i];
        }
        int[] ans = new int[n];
        int multiple = 1;
        for(int i=0;i<n;i++){
            ans[i] = multiple*post[i+1];
            multiple *= a[i];
        }
        return ans;
    }

    public int[] constructArr2(int[] a) {
        int n = a.length;
        int[] post = new int[n];
        for(int i = n-1;i>=0;i--){
            post[i] =(i==n-1?1:post[i+1])*a[i];
        }
        int multiple = 1;
        for(int i=0;i<n;i++){
            post[i] = (i==n-1?1:post[i+1])*multiple;
            multiple *= a[i];
        }
        return post;
    }
}
