package org.cxz.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/11/17 23:52
 */
public class case792 {
    public Map<Character,List<Integer>> map;
    public int numMatchingSubseq(String s, String[] words) {
        map = new HashMap();
        for(int i=0;i<s.length();i++){
            List<Integer> list = map.getOrDefault(s.charAt(i),new ArrayList());
            list.add(i);
            map.put(s.charAt(i),list);
        }
        int ans =0;
        for(String w:words){
            if(words.length>s.length()) continue;
            if(check(s,w)){
                ans++;
            }
        }
        return ans;
    }

    public boolean check(String s,String w){
        boolean res = true;
        int idx =-1;
        for(int i=0;i<w.length();i++){
            List<Integer> list = map.getOrDefault(w.charAt(i), new ArrayList<>());
            int l =0,r = list.size()-1;
            int mid = 0;
            while(l<r){
                mid = l+(r-l)/2;
                int cur = list.get(mid);
                if(cur>idx){
                    r= mid;
                }
                else{
                    l = mid+1;
                }
            }
            if(r<0||list.get(r)<=idx) return false;
            idx = list.get(r);
        }
        return res;
    }
}
