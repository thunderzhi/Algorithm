package org.cxz.contest.test2023345week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/14 10:28
 */
public class test0514a {

    public int[] circularGameLosers(int n, int k) {
        // 1  2  3  4  5  1  2  3  4  5
        // 1     2           3
        // 0 n-1  n
        int[] cnt = new int[n];
        cnt[0]=1;
        int cur = 0,r=1;
        int m = 0;
        while(cnt[cur]<=1){
            int nx = (cur+k*r)%n;
            if(cnt[nx]==1) break;
            cnt[nx]+=1;
            if(cnt[nx]==1) m++;
            cur = nx;
            r++;
        }
        int[] ans = new int[n-m-1];
        for (int i = 0,j=0; i < n; i++) {
            if(cnt[i]>0) continue;
            ans[j++] = i+1;
        }
        return ans;


    }
}
