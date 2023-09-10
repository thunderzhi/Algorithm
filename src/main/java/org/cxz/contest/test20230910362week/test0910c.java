package org.cxz.contest.test20230910362week;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/10 10:20
 */
public class test0910c {

    int[] cnt;
    int zero,ans;
    public int getidx(int x,int y){
        return 3*x+y;
    }
    public int minimumMoves(int[][] grid) {
        cnt = new int[9];
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cnt[getidx(i,j)] = grid[i][j];

                if(grid[i][j]==0) zero++;
            }
        }
        if(zero==0) return 0;
        dfs(9,0);
        return ans;
    }

    void dfs(int idx,int cost){
        if(zero==0){
            ans = Math.min(ans,cost);
            return;
        }
        // zero>0
        if(idx==9){
            // should choose one
            int nx = -1;
            for (int i = 0; i < 9; i++) {
                if(cnt[i]>1){
                    nx = i;
                    break;
                }
            }
            // chose one zero pos
            for (int i = 0; i < 9; i++) {
                if(cnt[i]==0){
                    int zx = i/3,zy = i%3;
                    int curx = nx/3,cury = nx%3;
                    int dis = Math.abs(zx-curx)+Math.abs(zy-cury);
                    cnt[nx]--;
                    cnt[i] =1;
                    zero--;
                    dfs(nx,cost+dis);
                    cnt[i] =0;
                    zero++;
                    cnt[nx]++;
                }
            }
        }
        else{
            if(cnt[idx]<=1){
                // choose another pos
                for (int i = 0; i < 9; i++) {
                    if(cnt[i]>1){
                        idx = i;
                        break;
                    }
                }
            }
            for (int i = 0; i < 9; i++) {
                if(cnt[i]!=0)continue;
                int zx = i/3,zy = i%3;
                int curx = idx/3,cury = idx%3;
                int dis = Math.abs(zx-curx)+Math.abs(zy-cury);
                cnt[idx]--;
                cnt[i]=1;
                zero--;
                dfs(idx,cost+dis);
                zero++;
                cnt[i]=0;
                cnt[idx]++;
            }
        }
        return;
    }

}
