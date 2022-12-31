package org.cxz.algorithm.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/2 17:27
 */
public class case743 {
	
	public int[][] w;
    public int[] dist;
    public boolean[] vis;
    public int max;
    public int _n;
    public int networkDelayTime(int[][] times, int n, int k) {
        w = new int[n+1][n+1];
        _n = n;
        max = 0x3f3f3f3f;
        for(int i=0;i<=n;i++){
            Arrays.fill(w[i],max);
            w[i][i]=0;
        }        
        dist = new int[n+1];
        vis = new boolean[n+1];
        for(int i = 0;i<times.length;i++){
            int from = times[i][0];
            int to = times[i][1];
            w[from][to] = times[i][2];
            //System.out.println("w["+from+"]["+to+"]:"+w[from][to]);
        }
        dijkstra(k,n);
        int ans =0;
        for(int i = 1;i<=n;i++){
            //System.out.println("dist["+i+"]:"+dist[i]);
            ans = Math.max(ans,dist[i]);
        }
        return ans>=max?-1:ans;
    }

    public void dijkstra(int k,int n){
        Arrays.fill(dist,max);
        dist[k] =0;        
        for(int i =1;i<=n;i++){
            int ind = -1;
            for(int j =1;j<=n;j++){
                if(!vis[j]&&(ind==-1||dist[ind]>dist[j])){
                    ind = j;
                }
            }
            //System.out.println("vis["+ind+"]:"+ind);
            vis[ind] = true;
            for(int j=1;j<=n;j++){
                int tmp = dist[ind]+w[ind][j];
                //System.out.println("tmp:"+tmp+"dist["+j+"]:"+dist[j]);
                dist[j] = Math.min(dist[j],dist[ind]+w[ind][j]);
            }
            //System.out.println("dist:"+Arrays.toString(dist));
        }
        return;
    }
    // 堆优化的dijkstra
    public void dk(int k,int n){
        Arrays.fill(dist,max);
        dist[k] =0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{
            return a[1]-b[1];
        });
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int ind = top[0];
            if(vis[ind]) continue;
            vis[ind] = true;
            //int size = w[ind].length;
            for (int i = 1; i <= n ; i++) {
                //if(w[ind][i]>max) continue;
                if(dist[i]>dist[ind]+w[ind][i]){
                    dist[i]=dist[ind]+w[ind][i];
                    pq.offer(new int[]{i,dist[i]});
                }
            }
        }
    }
    //朴素的 Bellman ford DP
    public void bellmanFord(int k ,int n ){
        // 原点k 到 节点 j，最多经过i条边 的最短路径为 f[i][j]
        // 最短路径 最多不会超过 n-1条边，f[n-1][j] 就是存储 原点k 到节点j的最短路径
        int[][] f = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i],max);
        }
        f[0][k] = 0;
        for (int i = 1; i <n; i++) {
            for (int j =1; j <=n ; j++) {
                for (int l = 1; l <=n; l++) {
                    f[i][j] =Math.min(f[i][j],f[i-1][l] +w[l][j]);
                }
            }
        }
        dist = f[n-1].clone();
        return;
    }
}
