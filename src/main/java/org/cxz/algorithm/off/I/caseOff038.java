package org.cxz.algorithm.off.I;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: backtrack not good ver 1
 * @date 2022/2/16 15:02
 */
public class caseOff038 {
    public Set<String> ansset;
    public String[] permutation(String s) {
        ansset = new HashSet();
        Map<Character,Integer> map = new HashMap();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        LinkedList<Character> track = new LinkedList();
        backtrack(s,0,track,map);

        String[] ans = new String[ansset.size()];
        int p =0;
        for(String str: ansset){
            ans[p++]= str;
        }
        return ans;
    }
    public void backtrack(String s, int ind,
                          LinkedList<Character> track, Map<Character,Integer> map ){
        if(track.size()==s.length()){
            StringBuffer sb = new StringBuffer();
            for(Character c: track){
                sb.append(c);
            }
            if(!ansset.contains(sb.toString())){
                ansset.add(sb.toString());
            }
            return;
        }

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.get(c)==0) continue;
            track.addLast(c);
            map.put(c,map.get(c)-1);
            backtrack(s,ind+1,track,map);
            track.removeLast();
            map.put(c,map.get(c)+1);
        }
        return;
    }
}
