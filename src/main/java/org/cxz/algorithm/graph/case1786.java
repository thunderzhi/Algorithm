package org.cxz.algorithm.graph;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/3/13 15:36
 */
public class case1786 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        int n = 20000;
        int a = 0x3f3f3f3f;

        System.out.println("res = " + (a<Integer.MAX_VALUE));

    }

    public int countRestrictedPaths2(int n, int[][] edges) {
        int INF = Integer.MAX_VALUE;// INF should be MAX
        boolean[] vis = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist,INF);
        Map<Integer,Map<Integer,Integer>> map = new HashMap();
        for(int[] ed: edges){
            int a = ed[0],b = ed[1],w= ed[2];
            Map<Integer,Integer> am;
            Map<Integer,Integer> bm;
            am = map.getOrDefault(a,new HashMap());
            bm = map.getOrDefault(b,new HashMap());
            am.put(b,w);
            map.put(a,am);
            bm.put(a,w);
            map.put(b,bm);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{return a[1]-b[1];});
        dist[n]=0;
        pq.offer(new int[]{n,0});
        while(!pq.isEmpty()){
            int[] e = pq.poll();
            int id = e[0];
            if(vis[id]) continue;
            vis[id] = true;
            Map<Integer,Integer> m;
            m = map.get(id);
            if(m==null) continue;
            for(Integer i : m.keySet()){
                dist[i] = Math.min(dist[i],dist[id]+m.get(i));
                pq.offer(new int[]{i,dist[i]});
            }
        }
        int[][] arr = new int[n][2];
        for(int i =0;i<n;i++){
            arr[i] = new int[]{i+1,dist[i+1]};
        }
        System.out.println(" dist: "+ Arrays.toString(dist));
        Arrays.sort(arr,(a,b)->{return a[1]-b[1];});
        int[] f = new int[n+1];
        int MOD = 1000000007;
        f[n] = 1;
        for (int i = 0; i < n; i++) {
            int idx = arr[i][0], cur = arr[i][1];
            //System.out.println(" idx: "+ idx);
            Map<Integer, Integer> mm = map.get(idx);
            if (mm == null) continue;
            for (int next : mm.keySet()) {
                //System.out.println(" nx: "+ next+ " cur: "+cur);
// System.out.println("dist nx: "+ dist[next] );

                if (cur > dist[next]) {
                    f[idx] = f[idx]%MOD+ f[next]%MOD;
                    f[idx] %= MOD;
                }
                System.out.println("f["+idx+"] : "+ f[idx] );

            }
            // 第 1 个节点不一定是距离第 n 个节点最远的点，但我们只需要 f[1]，可以直接跳出循环
            //if (idx == 1) break;
        }

        return f[1];
    }

    public int countRestrictedPaths1(int n, int[][] es) {
        // 预处理所有的边权。 a b w -> a : { b : w } + b : { a : w }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] e : es) {
            int a = e[0], b = e[1], w = e[2];
            Map<Integer, Integer> am = map.getOrDefault(a, new HashMap<Integer, Integer>());
            am.put(b, w);
            map.put(a, am);
            Map<Integer, Integer> bm = map.getOrDefault(b, new HashMap<Integer, Integer>());
            bm.put(a, w);
            map.put(b, bm);
        }

        // 堆优化 Dijkstra：求 每个点 到 第n个点 的最短路
        int[] dist = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        Queue<int[]> q = new PriorityQueue<int[]>((a, b)->a[1]-b[1]); // 点编号，点距离。根据点距离从小到大
        q.add(new int[]{n, 0});
        while (!q.isEmpty()) {
            int[] e = q.poll();
            int idx = e[0], cur = e[1];
            if (st[idx]) continue;
            st[idx] = true;
            Map<Integer, Integer> mm = map.get(idx);
            if (mm == null) continue;
            for (int i : mm.keySet()) {
                dist[i] = Math.min(dist[i], dist[idx] + mm.get(i));
                q.add(new int[]{i, dist[i]});
            }
        }

        // dp 过程
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) arr[i] = new int[]{i + 1, dist[i + 1]}; // 点编号，点距离
        Arrays.sort(arr, (a, b)->a[1]-b[1]); // 根据点距离从小到大排序

        // 定义 f(i) 为从第 i 个点到结尾的受限路径数量
        // 从 f[n] 递推到 f[1]
        int[] f = new int[n + 1];
        f[n] = 1;
        for (int i = 0; i < n; i++) {
            int idx = arr[i][0], cur = arr[i][1];
            Map<Integer, Integer> mm = map.get(idx);
            if (mm == null) continue;
            for (int next : mm.keySet()) {
                System.out.println(" nx: "+ next+ " cur: "+cur);
                if (cur > dist[next]) {
                    f[idx] += f[next];
                    f[idx] %= mod;
                }
                System.out.println("f["+idx+"] : "+ f[idx] );
            }
            // 第 1 个节点不一定是距离第 n 个节点最远的点，但我们只需要 f[1]，可以直接跳出循环
            if (idx == 1) break;
        }
        return f[1];
    }
}
