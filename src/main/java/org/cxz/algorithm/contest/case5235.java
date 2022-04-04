package org.cxz.algorithm.contest;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/3 10:52
 */
public class case5235 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> win = new HashMap();
        Map<Integer,Integer> lose = new HashMap();
        PriorityQueue<Integer> winq = new PriorityQueue();
        PriorityQueue<Integer> loseq = new PriorityQueue();
        List<List<Integer>> ans = new ArrayList<>();
        int n = matches.length;
        for(int i =0;i<n;i++){
            int winnum = matches[i][0];
            int losenum = matches[i][1];
            win.put(winnum,win.getOrDefault(winnum,0)+1);
            lose.put(losenum,lose.getOrDefault(losenum,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: win.entrySet()){
            int key = entry.getKey();
            if(lose.containsKey(key)) continue;
            winq.offer(key);
        }
        for(Map.Entry<Integer,Integer> entry: lose.entrySet()){
            if(entry.getValue()!=1) continue;
            loseq.offer(entry.getKey());
        }
        List<Integer> winlist = new ArrayList<>();
        while(!winq.isEmpty()){ winlist.add(winq.poll()); }
        List<Integer> loselist = new ArrayList<>();
        while(!loseq.isEmpty()){ loselist.add(loseq.poll()); }
        ans.add(winlist);
        ans.add(loselist);
        return ans;


    }
}
