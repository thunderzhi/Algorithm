package org.cxz.contest.test93dweek;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/10 22:31
 */
public class test1210c {

    public int maxStarSum(int[] vals, int[][] edges, int k) {

        List<PriorityQueue<Integer>> g = new ArrayList<>();
        int n = vals.length;
        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->{
                return b-a;
            });
            g.add(pq);
        }
        for(int[] ed :edges){
            int x = ed[0];
            int y = ed[1];
            g.get(x).offer(vals[y]);
            g.get(y).offer(vals[x]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int t = vals[i];
            ans = Math.max(ans,t);
            int cnt =0;
            int pre = vals[i];
            PriorityQueue<Integer> p = g.get(i);
            while(cnt<k&&!p.isEmpty()){
                System.out.println( "Node "+i+" next " + p.peek());
                if(p.peek()<=0) break;
                pre += p.poll();
                cnt++;
                ans = Math.max(ans,pre);
            }
        }
        return ans;
    }

}
