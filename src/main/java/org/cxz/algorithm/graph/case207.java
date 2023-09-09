package org.cxz.algorithm.graph;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/23 0:33
 */
public class case207 {

    //ver1 topo BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList();
        HashMap<Integer,List<Integer>> g = new HashMap();
        for(int[] x :prerequisites){
            int from = x[1];
            int to = x[0];
            if(!g.containsKey(from)) g.put(from,new ArrayList());
            g.get(from).add(to);
            indegree[to]++;
        }
        for(int i =0;i<numCourses; i++){
            if(indegree[i]==0) queue.offer(i);
        }
        int ans = 0;
        while(!queue.isEmpty()){
            int t = queue.poll();
            ans++;
            List<Integer> l = g.get(t);
            if(l==null||l.size()==0) continue;
            for(int i: l){
                indegree[i]--;
                if(indegree[i]==0) queue.offer(i);
            }
        }
        return ans==numCourses;
    }

    List<List<Integer>> g;
    int[] vis;
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        g = new ArrayList();
        vis = new int[numCourses];
        for(int i =0;i<numCourses;i++){
            g.add(new ArrayList());
        }
        for(int[] pre: prerequisites){
            int to = pre[0], from = pre[1];
            g.get(from).add(to);
        }
        boolean ans = true;
        for(int i =0;i<numCourses&&ans;i++){
            if(vis[i]==2) continue;
            ans &= dfs(i);
        }
        return ans;
    }
    // 1 visiting 2 visited 0 non visit
    public boolean dfs(int cur){
        if(vis[cur]==1) return false;
        if(vis[cur]==2) return true;
        vis[cur] = 1;
        List<Integer> list = g.get(cur);
        boolean res = true;
        for(int y: list){
            if(vis[y]==1) return false;
            if(vis[y]==0){
                res &= dfs(y);
                if(!res) return false;
            }
        }
        vis[cur]=2;
        return res;
    }
}
