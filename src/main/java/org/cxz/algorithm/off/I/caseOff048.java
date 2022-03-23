package org.cxz.algorithm.off.I;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/23 19:09
 */
public class caseOff048 {

    //ver 1
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap();
        int n = s.length();
        if(n==0) return 0;
        int ans = 0;
        int l=0,r=0;
        while(r<n){
            char c = s.charAt(r);
            int pre = map.containsKey(c)?map.get(c):-1;
            map.put(c,r);
            while(pre!=-1&&l<=pre){
                l++;
            }
            if(l<=r){
                ans = Math.max(ans,r-l+1);
            }
            r++;
        }
        return ans;
    }
}
