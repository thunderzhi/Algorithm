package org.cxz.algorithm.dynamic;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/11 19:01
 */
public class caseFreqStack2 {

    public int Max = 0;
    public Map<Integer, Deque<Integer>> map ;
    public Map<Integer,Integer> freqmap ;

    public caseFreqStack2() {
        map = new HashMap();
        freqmap = new HashMap();
    }

    public void push(int val) {
        freqmap.put(val,freqmap.getOrDefault(val,0)+1);
        int cnt = freqmap.get(val);
        Max = Math.max(Max,cnt);
        if(!map.containsKey(cnt)){
            map.put(cnt,new LinkedList());
        }
        map.get(cnt).offerLast(val);
    }

    public int pop() {
        Deque<Integer> st = map.get(Max);
        int ans = st.pollLast();
        if(st.isEmpty()) Max--;
        freqmap.put(ans,freqmap.get(ans)-1);
        return ans;
    }
}
