package org.cxz.algorithm.off;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/27 22:34
 */
public class off50 {
    public static void main(String[] args) {

    }
    //11min

    public char firstUniqChar(String s) {
        if(s.length()==0){
            return ' ';
        }
        int[] cnt = new int[26];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int t = c-'a';
            cnt[t] +=1;
            if(!map.containsKey(c)){
                map.put(c,i);
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o1)-map.get(o2);
            }
        });
        for (int i=0;i<cnt.length;i++){
            if(cnt[i]==1){
                char c = (char)(i+'a');
                pq.offer(c);
            }
        }
        return pq.peek();
    }
}
