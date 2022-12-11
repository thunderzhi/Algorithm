package org.cxz.contest.test323week;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/11 10:31
 */
public class test1211a {
    public int deleteGreatestValue(int[][] grid) {
        int  n = grid.length ,m = grid[0].length;
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->{
                return b-a;
            });
            for (int j = 0; j < m; j++) {
                pq.offer(grid[i][j]);

            }
            System.out.println("pq = " + pq.size());
            list.add(pq);
        }
        int ans= 0;
        for (int i = 0; i < m; i++) {
            int max = 0;
            System.out.println("i = " + i);
            for (int j = 0; j < n; j++) {
                max = Math.max(max,list.get(j).poll());
                //System.out.println("pq "+j+" = " + list.get().size());
            }
            System.out.println("max = " + max);
            ans += max;
        }
        return ans;
    }
}
