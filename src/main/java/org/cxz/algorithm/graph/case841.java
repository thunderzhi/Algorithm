package org.cxz.algorithm.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/25 16:12
 */
public class case841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis = new boolean[rooms.size()];
        int cnt = vis.length; 
        Queue<Integer> pq = new LinkedList();
        pq.offer(0);
        while(!pq.isEmpty()){
            int ind = pq.poll();
            if(vis[ind]) continue;
            vis[ind] = true;
            cnt-=1;
            for(Integer k: rooms.get(ind)){
                if(vis[k])continue;
                pq.offer(k);
            }
        }
        return cnt==0;
    }
}
