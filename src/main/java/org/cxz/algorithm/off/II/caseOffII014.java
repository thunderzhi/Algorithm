package org.cxz.algorithm.off.II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/23 18:18
 */
public class caseOffII014 {

    //ver 1 hash
    public boolean checkInclusion1(String s1, String s2) {
        Map<Character,Integer> mark = new HashMap();
        for(int i = 0 ;i<s1.length();i++){
            char c =s1.charAt(i);
            mark.put(c,mark.getOrDefault(c,0)-1);
        }
        int l= 0,r=0,cnt=0;
        int n = s2.length();
        while(r<n){
            char c = s2.charAt(r);
            r++;
            if(mark.containsKey(c)){
                mark.put(c,mark.getOrDefault(c,0)+1);
                cnt++;
            }

            while(r-l>s1.length()){
                if(mark.containsKey(s2.charAt(l))){
                    mark.put(s2.charAt(l),mark.get(s2.charAt(l))-1);
                    cnt--;
                }
                l++;
            }
            if(r-l==s1.length()&&cnt==s1.length()&&check(mark)) {
                return true;
            }

        }
        return false;
    }

    public boolean check(Map<Character,Integer> mark){
        boolean ans = true;
        for(Map.Entry<Character,Integer> entry: mark.entrySet()){
            if(entry.getValue()!=0) return false;
        }
        return ans;
    }
}
