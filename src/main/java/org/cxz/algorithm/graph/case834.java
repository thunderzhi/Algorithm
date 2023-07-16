package org.cxz.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/16 20:14
 */
public class case834 {

    public List<Integer>[] g;
    public int n;
    int[] ans,arr;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        ans = new int[n];
        arr = new int[n];
        g = new ArrayList[n];
        for(int i =0;i<n;i++){
            g[i] =new ArrayList();
        }
        for(int[] e: edges){
            int x = e[0],y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        dfs(0,-1,0);
        reroot(0,-1);
        return ans;
    }

    public int dfs(int node,int fa,int d){
        int sum = 1;
        ans[0]+=d;
        List<Integer> child = g[node];
        for(int c: child){
            if(c==fa)continue;
            sum += dfs(c,node,d+1);
        }
        arr[node] = sum ;
        return sum;
    }
    public void reroot(int cur,int fa){
        List<Integer> child = g[cur];
        for(int c: child){
            if(c==fa)continue;
            ans[c] = ans[cur]+ n- 2*arr[c] ;
            reroot(c,cur );
        }
        return;
    }
}
