package org.cxz.algorithm.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/3/14 14:51
 */
public class case1976 {

    int N = 210, MOD = (int)1e9+7;
    long INF = (long)1e12;
    int[][] g = new int[N][N];
    int[] in = new int[N];
    Long[] dist = new Long[N];
    boolean[] vis = new boolean[N];
    int n;
    public int countPaths(int _n, int[][] rs) {
        n = _n;
        for (int[] info : rs) {
            int a = info[0], b = info[1], c = info[2];
            g[a][b] = g[b][a] = c;
        }
        // 朴素 Dijkstra 求解从 0 点到其他点的最短路
        dijkstra();
        // 利用最短路重新建图，并统计入度
        for (int[] info : rs) {
            int a = info[0], b = info[1], c = info[2];
            g[a][b] = g[b][a] = 0;
            if (dist[a] + c == dist[b]) {
                g[a][b] = c; in[b]++;
            } else if (dist[b] + c == dist[a]) {
                g[b][a] = c; in[a]++;
            }
        }
        // 跑拓扑排序统计方案数
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) d.addLast(i);
        }
        int[] f = new int[n];
        f[0] = 1;
        while (!d.isEmpty()) {
            int x = d.pollFirst();
            for (int i = 0; i < n; i++) {
                if (g[x][i] == 0) continue;
                f[i] += f[x];
                f[i] %= MOD;
                if (--in[i] == 0) d.addLast(i);
            }
        }
        return f[n - 1];
    }
    void dijkstra() {
        Arrays.fill(dist, INF);
        dist[0] = 0L;
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a, b)->{
            return (int)(a[1]-b[1]);
            // return (int)(dist[a]).compareTo(dist[b]);
            // return dist[a]).compareTo(dist[b]);
        });
        pq.offer(new long[]{0L,0L});
        while(!pq.isEmpty()){
            // long id = pq.poll();
            long[] ele = pq.poll();
            int id = (int)ele[0];
            long d = ele[1];
            if(vis[id]) continue;
            vis[id] = true;
            for(int i =0;i<g[id].length;i++){
                if(i==id)continue;
                if(g[id][i]==0) continue;
                dist[i] = Math.min(dist[i],dist[id]+g[id][i]);
                pq.offer(new long[]{i*1L,dist[i]});
            }
        }
        return;
    }
}
