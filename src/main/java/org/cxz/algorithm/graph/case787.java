package org.cxz.algorithm.graph;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/3/13 17:20
 */
public class case787 {

    int N = 110, INF = 0x3f3f3f3f;
    int[][] g = new int[N][N];
    int[] dist = new int[N];
    int n, m, s, t, k;
    public int findCheapestPrice(int _n, int[][] flights, int _src, int _dst, int _k) {
        n = _n; s = _src; t = _dst; k = _k + 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                g[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] f : flights) {
            g[f[0]][f[1]] = f[2];
        }
        int ans = bf();
        return ans > INF / 2 ? -1 : ans;
    }
    int bf() {
        Arrays.fill(dist, INF);
        dist[s] = 0;
        for (int limit = 0; limit < k; limit++) {
            int[] clone = dist.clone();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[j] = Math.min(dist[j], clone[i] + g[i][j]);
                }
            }
        }
        return dist[t];
    }
}
