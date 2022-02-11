package org.cxz.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/11 12:51
 */
public class case1647 {

    public int minDeletions(String s) {
        char[] arr = s.toCharArray();
        int[] C = new int[26];
        Set<Integer> set = new HashSet();
        for(char c: arr){
            C[c-'a']++;
        }
        int ans = 0;
        for(int i: C){
            if(i==0) continue;
            while(set.contains(i)&&i>0){
                i--;
                ans++;
            }
            if(i>0) set.add(i);
        }
        return ans;
    }
}
