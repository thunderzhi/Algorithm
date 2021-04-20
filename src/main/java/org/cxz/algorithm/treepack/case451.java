package org.cxz.algorithm.treepack;

import java.awt.color.ICC_ProfileGray;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/20 22:53
 */
public class case451 {

    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (Character character : map.keySet()) {

            pq.offer(character);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Character poll = pq.poll();
            int leng = map.get(poll);
            for (int i = 0; i < leng; i++) {
                sb.append(poll);
            }
        }
        return sb.toString();


    }
}
