package org.cxz.algorithm.array;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/11 10:40
 */
public class case2512 {
    public int getscore(String str){
        String[] arr = str.split(" ");
        int sum =0;
        for(String s : arr){
            if(pset.contains(s)) sum+=3;
            if(nset.contains(s)) sum-=1;
        }
        return sum;
    }
    Set<String> pset,nset;
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        pset = new HashSet();
        nset = new HashSet();
        for(String s :positive_feedback) pset.add(s);
        for(String s :negative_feedback) nset.add(s);
        // 0 id 1 score
        PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>((a, b)->{
            if(a[1]==b[1]) return a[0]-b[0];
            return b[1]-a[1];
        });
        int n = report.length;
        for(int i =0;i<n;i++ ){
            int id = student_id[i];
            String r = report[i];
            int score = getscore(r);
            pq.offer(new Integer[]{id,score});
        }

        List<Integer> ans = new ArrayList();
        while(k>0&& !pq.isEmpty()){
            int id = pq.peek()[0],score = pq.peek()[1];
//System.out.println("id "+id + " score  "+ score);
            ans.add(pq.poll()[0]);
            k--;
        }
        return ans;
    }
}
