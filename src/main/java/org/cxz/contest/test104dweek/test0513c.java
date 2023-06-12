package org.cxz.contest.test104dweek;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/13 22:28
 */
public class test0513c {
    public int matrixSum(int[][] nums) {
        int rows = nums.length,cols = nums[0].length;
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->{
               return b-a;
            });
            for (int j = 0; j < nums[i].length; j++) {
                pq.offer(nums[i][j]);
            }
            list.add(pq);
        }
        int ans = 0;
        for (int ind=0; ind < cols; ind++) {
            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                PriorityQueue<Integer> pq = list.get(i);
                if(pq.isEmpty()) continue;
                int p = pq.poll();
                if(max<p) max = p;
            }
            ans+=max;
        }
        return ans; 
    }
}
