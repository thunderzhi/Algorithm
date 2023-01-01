package org.cxz.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/2 17:27
 */
public class case743b {

    public class Edge{
        public int a;
        public int b;
        public int c;
        public Edge(int _a,int _b,int _c){
            a=_a;b=_b;c=_c;
        }
    }

    public int[] dist;
    public boolean[] vis;
    public int max;
    public List<Edge> list;
    public int networkDelayTime(int[][] times, int n, int k) {
        list = new ArrayList<>();
        for (int[] t:times) {
            Edge e = new Edge(t[0],t[1],t[2]);
            list.add(e);
        }
        max = 0x3f3f3f3f;
        dist = new int[n+1];
        vis = new boolean[n+1];
        bellmanFord(k,n);
        int ans =0;
        for(int i = 1;i<=n;i++){
            //System.out.println("dist["+i+"]:"+dist[i]);
            ans = Math.max(ans,dist[i]);
        }
        return ans>=max?-1:ans;
    }


    //枚举N个节点的循环，每个循环内 再循环M条边 的 Bellman ford
    public void bellmanFord(int k ,int n ){
        Arrays.fill(dist,max);
        dist[k] = 0;
        for (int i = 1; i <=n; i++) {
            int[] pre = dist.clone();
            for (Edge e:list) {
                int from = e.a;
                int to = e.b;
                int w = e.c;
                dist[to] =Math.min(dist[to],pre[from]+w);
            }
        }
        return;
    }




}
