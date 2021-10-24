package org.cxz.algorithm.unionfind;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/24 13:31
 */
public class case1202 {

    public static void main(String[] args) {

    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionSet u = new UnionSet(s.length());
        List<PriorityQueue<Character>>  pq = new ArrayList<>();
        for(int i =0;i<s.length();i++){
            pq.add(new PriorityQueue<>());
        }
        for(int i =0;i<pairs.size();i++){
            List<Integer> t = pairs.get(i);
            int x = t.get(0);
            int y = t.get(1);
            System.out.println("merge = " + x+" & "+y);
            u.merge(x,y);
        }

        for(int i=0;i<s.length();i++){
            pq.get(u.get(i)).offer(s.charAt(i));
        }
        StringBuffer sb = new StringBuffer();

        //String ret ="";
        for(int i =0;i<s.length();i++){
            //ret+= pq.get(u.get(i)).poll();
            sb.append(pq.get(u.get(i)).poll());
        }

        return sb.toString();




    }
}
