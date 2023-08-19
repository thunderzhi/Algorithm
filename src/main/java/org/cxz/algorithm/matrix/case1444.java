package org.cxz.algorithm.matrix;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/19 10:30
 */
public class case1444 {
    int[][] sum;
    int[][] memo;
    int rows,cols;
    int Mod = (int)1e9+7;
    String[] mat;
    public int getidx(int x,int y){
        return y+ x*cols;
    }
    public int ways(String[] pizza, int k) {
        rows = pizza.length;
        cols = pizza[0].length();
        sum = new int[rows+1][cols+1];
        int cnt  = rows*cols;
        memo = new int[cnt][k+1];
        mat = pizza;
        // process sum
        process();
        for(int i = 0;i<cnt;i++){
            Arrays.fill(memo[i] ,-1);
        }
        int res = dfs(0,k);
        return res;
    }
    // 区间内 要分给left 人 苹果的方案数
    public int dfs(int lu ,int left){
        if(memo[lu][left]!=-1){
            return memo[lu][left];
        }
        int tot = count(lu);// have apples
        if(tot<left) return 0;
        //left <= tot
        if(left==1){
            return tot>=1?1:0;
        }
        // 够分
        int x0 = lu/cols, y0= lu%cols;
        // 横切 算上面
        int res = 0;
        for(int i = x0;i<rows;i++){
            //next row
            int nr = i+1;
            if(nr>=rows) break;
            int cut = y0+nr*cols;
            int p2 = count(cut);
            // not enough
            if(p2<left-1) continue;
            int p1 = tot - p2;
            if(p1<1)continue;
            res += dfs(cut,left-1);
            res %=Mod;
        }
        // 竖切
        for(int i = y0;i<cols;i++){
            //next cols
            int nc = i+1;
            if(nc>=cols) break;
            int cut = nc+ x0*cols;
            int p2 = count(cut);
            // not enough
            if(p2<left-1) continue;
            int p1 = tot -p2;
            if(p1<1)continue;
            res += dfs(cut,left-1);
            res %=Mod;
        }
        return memo[lu][left] = res;
    }

    public void process(){
        for(int i = 1;i<=rows;i++){
            for(int j = 1;j<=cols;j++){
                int cur = mat[i-1].charAt(j-1)=='A'?1:0;
                int a = sum[i][j-1];
                int b = sum[i-1][j];
                int c = sum[i-1][j-1];
                sum[i][j] = a+b-c+cur;
            }
        }
        return ;
    }
    public int count(int A){
        int x0 = A/cols, y0= A%cols;
        x0++;y0++;
        int tot = sum[rows][cols];
        tot -= sum[x0-1][cols];
        tot -= sum[rows][y0-1];
        tot += sum[x0-1][y0-1];
        return tot;
    }

}
