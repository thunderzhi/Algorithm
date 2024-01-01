package org.cxz.contest.test2023118dweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/26 10:21
 */
public class test1125 {


    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if( words[i].indexOf(x)!=-1) list.add(i);
        }
        return list;
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        long colmax,rowmax;
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        // 最多连续的 r
        int cntr = 1,lenh = hBars.length;
        for (int i = 0; i < hBars.length; i++) {
            int j = i+1;
            if(j<lenh&& hBars[j]== hBars[i]+1){
                while(j<lenh&& hBars[j]==hBars[j-1]+1 ) j++;
                int cnt = j - i;
                cntr = Math.max(cntr,cnt);
                i = j-1;
            }
        }
        // cntr
        int lenr = cntr+1;
        colmax = m+2;
        rowmax = n+2;

        int cntc = 1,lenv = vBars.length;
        for (int i = 0; i < vBars.length; i++) {
            int j = i+1;
            if(j<lenv&& vBars[j]== vBars[i]+1){
                while(j<lenv&& vBars[j]==vBars[j-1]+1 ) j++;
                int cnt = j - i;
                cntc = Math.max(cntc,cnt);
                i = j-1;
            }
        }
        int lenc = cntc+1;
        int l = Math.min(lenc,lenr);
        return l*l;
    }

    public int minimumCoins(int[] prices) {
        // f[i][0] 可以买第i个不花钱的最少总支出
        // f[i][1] 可以买第i个花钱的最少总支出
        // f[i][0] =min( f[j][1] (j+1~j+j >= i ) ) j>=i/2&&j<i
        //f[i][1] = f[i-1][0] or f[i-1][1]  + prices[i-1]
        int n= prices.length,INF = Integer.MAX_VALUE/2;
        //0~n-1 ---》 1~n
        int[][] f = new int[n+2][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i],INF);
        }
        f[1][0] = INF;f[1][1] = prices[0];
        for (int i = 2; i <=n ; i++) {
            for (int j = (i+1)/2; j <i ; j++) {
                f[i][0] = Math.min(f[i][0],f[j][1]);
            }
            f[i][1] = Math.min(f[i][1],f[i-1][0]+prices[i-1]);
            f[i][1] = Math.min(f[i][1],f[i-1][1]+prices[i-1]);
        }
        return Math.min(f[n][0],f[n][1]);



    }
}
