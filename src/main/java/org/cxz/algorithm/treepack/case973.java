package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/20 21:52
 */
public class case973 {

    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        List<List<Integer>> po = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            int a =points[i][0];
            int b =points[i][1];
            int c = a*a +b*b;
            tmp.add(a);
            tmp.add(b);
            tmp.add(c);
            po.add(tmp);
        }
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(2) - o1.get(2);
            }
        });
        for (List<Integer> integers : po) {
            pq.offer(integers);
            if(pq.size()>k){
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            List<Integer> tmp = pq.poll();
            ans[i][0]=tmp.get(0);
            ans[i][1]=tmp.get(1);
        }
        return ans;
    }
}
