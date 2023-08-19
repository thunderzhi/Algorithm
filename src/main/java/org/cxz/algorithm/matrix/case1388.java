package org.cxz.algorithm.matrix;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/19 10:33
 */
public class case1388 {

    int INF;
    int[][] memo;
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int[] s1 = new int[n-1];//0~n-2
        int[] s2 = new int[n-1];//1~n-1
        for(int i= 1;i<n;i++){
            s1[i-1] = slices[i-1];
            s2[i-1] = slices[i];
        }
        INF = Integer.MIN_VALUE/2;
        int cnt = n/3;
        memo = new int[n][cnt+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        // 1~n   cnt
        // dfs(n,cnt);
        // dfs(i,cnt) = s[i-1] + dfs(i-2,cnt-1);
        // dfs(i,cnt) = 0 + dfs(i-1,cnt);
        int res = dfs(n-1,cnt,s1);
        for(int i = 0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        res = Math.max(res,dfs(n-1,cnt,s2));
        return res;
    }
    public int dfs(int idx,int cnt,int[] s){
        if(memo[idx][cnt]!=-1){
            return memo[idx][cnt];
        }
        if(cnt==0||idx<3){
            //cnt==0 idx = any
            if(cnt==0) return 0;
            // cnt ==any  idx<3
            //cnt==1 idx <3
            if(cnt==1){
                return idx==1?s[0]:Math.max(s[0],s[1]);
            }
            // cnt >1  idx<3
            return memo[idx][cnt] = INF;
        }
        // idx>=3 && cnt>0

        int res =dfs(idx-2,cnt-1,s)+s[idx-1];
        res = Math.max(res,dfs(idx-1,cnt,s));
        return memo[idx][cnt] = res;
    }
}
