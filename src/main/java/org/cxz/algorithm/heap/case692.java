package org.cxz.algorithm.heap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/14 14:21
 */
public class case692 {

    public static void main(String[] args) {
        String[] w = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> strings = new case692().topKFrequent(w, k);

        System.out.println(strings);
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer a = map.get(o1);
                Integer b = map.get(o2);
                int res =0;
                if(a.equals(b)){
                    res = o2.compareTo(o1);
                }
                else {
                    res = a -b;
                }
                return res;
            }
        });
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            pq.offer(item.getKey());
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(0,pq.poll());
        }
        return ans;
    }
}
