package org.cxz.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/7 17:47
 */
public class case796 {

    //ver1
    public boolean rotateString(String s, String goal) {
        if(s.length()==0&&goal.length()==0) return true;
        if(s.length()!=goal.length()) return false;
        int n = s.length();
        int p =0;
        Set<Integer> set = new HashSet();
        for(int i = 0;i<n;i++){
            if(s.charAt(i)!=goal.charAt(0)) continue;
            set.add(i);
        }
        for(Integer k: set){
            if(check(k,s,goal)) return true;
        }
        return false;
    }

    public boolean check(int p ,String s,String goal){
        int n = s.length();
        for(int i = 0;i<n;i++){
            int j = p%n;
            if(s.charAt(j)!=goal.charAt(i)){
                return false;
            }
            p++;
        }
        return true;
    }

    public boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

}
