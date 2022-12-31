package org.cxz.contest.test94dweek;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/24 22:30
 */
public class test1224b {
    public static void main(String[] args) {

    }
    public List<Integer> topStudents(String[] positive_feedback,
                                     String[] negative_feedback,
                                     String[] report,
                                     int[] student_id, int k) {
        Set<String> pos = new HashSet<>();
        Set<String> neg = new HashSet<>();
        for(String s: positive_feedback){
            pos.add(s);
        }
        for(String s: negative_feedback){
            neg.add(s);
        }
        int n =  student_id.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{
            if(a[1]!=b[1]) return a[1]-b[1];
            return b[0]-a[0];
        });
        int[][] id_score = new int[n][2];
        for (int i = 0; i < report.length; i++) {
            String[] s = report[i].split(" ");
            int socre = 0;
            for(String w: s){
                if(pos.contains(w)){
                    socre +=3;
                    continue;
                }
                if(neg.contains(w)){
                    socre -=1;
                    continue;
                }
            }
            int[] tmp = new int[]{student_id[i],socre};
            pq.offer(tmp);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            int id = pq.poll()[0];
            ans.add(0,id);
        }
        return ans;
    }
}
