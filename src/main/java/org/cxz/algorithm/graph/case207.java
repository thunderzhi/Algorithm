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
}
