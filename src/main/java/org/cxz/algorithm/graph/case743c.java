package org.cxz.algorithm.graph;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/2 17:27
 */
public class case743c {


    public int[] dist;
    public boolean[] vis;
    public int max;
    public List<List<int[]>> list;
    public int networkDelayTime(int[][] times, int n, int k) {
        list = new ArrayList<>();
        for (int i = 0; i <=n ; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] t:times) {
            int from = t[0];
            int to = t[1];
            list.get(from).add(new int[]{to,t[2]});
        }
        max = 0x3f3f3f3f;
        dist = new int[n+1];
        vis = new boolean[n+1];
        SPFA(k,n);
        int ans =0;
        for(int i = 1;i<=n;i++){
            //System.out.println("dist["+i+"]:"+dist[i]);
            ans = Math.max(ans,dist[i]);
        }
        return ans>=max?-1:ans;
    }


    //SPFA
    public void SPFA(int k ,int n ){
        Arrays.fill(dist,max);
        dist[k] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        vis[k] = true;
        while(!queue.isEmpty()){
            int p = queue.poll();
            vis[p] = false;
            for (int[] item: list.get(p)) {
                int from = p;
                int to = item[0];
                if(dist[to]>dist[from]+item[1]){
                    dist[to] = dist[from]+item[1];
                    if(!vis[to]){
                        queue.offer(to);
                        vis[to] =true;
                    }
                }
            }
        }
        return;
    }

    


}
