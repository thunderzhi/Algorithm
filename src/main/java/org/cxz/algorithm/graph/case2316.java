package org.cxz.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/21 9:51
 */
public class case2316 {
    boolean[] mark;
    List<Integer>[] g;

    public long countPairs(int n, int[][] edges) {
        int len = edges.length;
        if(len ==0){
            long v = (long)n;
            return (v-1)*v/2;
        }

        mark = new boolean[n];
        g = new ArrayList[n];
        Arrays.setAll(g, x->new ArrayList());
        for(int[] e: edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        List<Long> list = new ArrayList();
        long tot = 0;
        for(int i=0;i<n;i++){
            if(mark[i]) continue;
            long t = (long)dfs(i);
            for(long l: list){
                tot += t*l;
            }
            list.add(t);
        }
        return tot;
    }

    public int dfs(int id){
        if(mark[id]) return 0;
        mark[id] = true;
        int res = 1;
        for(int x : g[id]){
            res += dfs(x);
        }
        return res;
    }

    public long countPairs2(int n, int[][] edges) {

        mark = new boolean[n];
        g = new ArrayList[n];
        Arrays.setAll(g,x->new ArrayList());
        for(int[] e: edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        long tot = 0,ans =0;
        for(int i=0;i<n;i++){
            if(mark[i]) continue;
            long t = (long)dfs(i);
            ans += tot*t;
            tot += t;
        }
        return ans;
    }
}
