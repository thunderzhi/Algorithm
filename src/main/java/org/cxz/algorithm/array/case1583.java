package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/5/1 12:18
 */
public class case1583 {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] g = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n-1;j++){
                g[i][preferences[i][j]] = j;
            }
        }
        int[] like = new int[n];
        for(int i =0;i<pairs.length;i++){
            int x = pairs[i][0] ,y = pairs[i][1];
            like[x] = g[x][y]; //pair with i , quantity in i
            like[y] = g[y][x];
        }
        int ans =0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<like[i];j++){
                //u
                int u = preferences[i][j];
                if(g[u][i]>= like[u]) continue;
                ans++;
                break;//miss
            }
        }
        return ans;
    }
}
