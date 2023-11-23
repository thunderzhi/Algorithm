package org.cxz.contest.test2023117dweek;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/11 21:38
 */
public class test1111b {
    int lim;
    long[][] memo;
    public long distributeCandies(int n, int limit) {
        int ans =0 ;
        lim = limit;
        memo = new long[4][n+1];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(memo[i],-1);
        }
        return dfs(3,n);
    }

    public long dfs(int idx,int sum){
        if(memo[idx][sum]!=-1) return memo[idx][sum];
        if(idx==1){
            if(sum<0) return 0;
            return sum>lim?0:1;
        }
        if(sum<0&&idx>1) return 0;
        long res = 0;
        for (int i = 0; i <= lim ; i++) {
            res += dfs(idx-1,sum-i);
        }

//        System.out.println("idx = " + idx+" sum "+sum+" res "+res);
        return memo[idx][sum]=res;
    }
}
