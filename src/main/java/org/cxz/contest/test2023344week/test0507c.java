package org.cxz.contest.test2023344week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/7 10:26
 */
public class test0507b {

    int max ;
    Map<Integer,Integer> freq;// nums-- nums freq
    Map<Integer, Set<Integer>> f;// freq-- nums
    public test0507b() {
        freq = new HashMap<>();
        f = new HashMap<>();
        max =0;
    }

    public void add(int number) {
        freq.put(number,freq.getOrDefault(number,0)+1);
        int cnt = freq.get(number);
        if(max<cnt){
            f.put(cnt,new HashSet<>());
            Set<Integer> s = f.get(cnt);
            s.add(number);
            f.put(cnt,s);
            max = cnt;
            return;
        }
        // max>=cnt
        Set<Integer> s = f.getOrDefault(cnt,new HashSet<>());
        s.add(number);
        f.put(cnt,s);
        return ;
    }

    public void deleteOne(int number) {
        System.out.println("del number = " + number);
        if(!freq.containsKey(number)||freq.get(number)<=0) return;
         
        Integer i = freq.get(number);
        Set<Integer> s = f.get(i);
        s.remove(number);
        if(s.isEmpty()&&max == i){
            max--;
        }
        freq.put(number,i-1);
        return;
    }

    public boolean hasFrequency(int frequency) {

        if(max<frequency)return false;
        // max> frequency
        Set<Integer> s = f.getOrDefault(frequency, new HashSet<>());
        for( int i : s){
            if(freq.get(i)==frequency) return true;
        }
        return false;

    }
}



