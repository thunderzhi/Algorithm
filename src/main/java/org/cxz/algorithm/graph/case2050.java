package org.cxz.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/28 23:33
 */
public class case2050 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indeg = new int[n+1];
        List<Integer>[] g = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            g[i] = new ArrayList();
        }
        for(int[] re: relations){
            int from = re[0],to = re[1];
            indeg[to]++;
            g[from].add(to);
        }
        Queue<Integer> queue = new LinkedList();
        for(int i=1;i<=n;i++){
            if(indeg[i]>0) continue;
            queue.offer(i);
        }
        int[] f = new int[n+1];
        int ans =0;
        while(!queue.isEmpty()){
            int idx = queue.poll();
            int end = f[idx]+ time[idx-1];
            ans = Math.max(ans,end);
            for(int nx: g[idx]){
                f[nx]= Math.max(f[nx],end);
                indeg[nx]--;
                if(indeg[nx]==0){
                    queue.offer(nx);
                }
            }
        } 
        return ans;
    }
}
