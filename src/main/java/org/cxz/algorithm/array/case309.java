package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/5 11:00
 */
public class case309 {

    public int maxProfit(int[] prices) {
        //1 money 0 stock
        //f[i][0] = f[i-1][0] or f[i-2][1] -p[i-1]
        // f[i][1] = f[i-1][1] or f[i-1][0]+p[i-1];
        // (1,0) = (0,0,=inf) or(0,1,=0 )-p[0]
        // (1,1) = (0,1,=0) or (1-2=-1,0,inf)+p[0]
        int n = prices.length,INF = Integer.MIN_VALUE/2;
        int[][] f = new int[n+1][2];
        for(int i = 0;i<=n;i++) Arrays.fill(f[i],INF);
        f[0][1] = 0;
        for(int i = 1;i<=n;i++){
            int p = prices[i-1];
            f[i][0] = Math.max(f[i-1][0],f[Math.max(i-2,0)][1] -p);
            f[i][1] = Math.max(f[i-1][1] ,f[i-1][0]+p);
//System.out.println("i "+i+" f "+ Arrays.toString(f[i]));
        }
        return f[n][1];
    }
}
