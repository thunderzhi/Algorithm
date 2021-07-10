package org.cxz.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/6 11:33
 */
public class case003 {
    public static void main(String[] args) {
       int l = new case003().lengthOfLongestSubstring("au");
        System.out.println("l = " + l);
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")){
            return 0;
        }
        int n = s.length();
        if(n==1){
            return 1;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int ans =0;
        int k = 0;
        int left = 0;
        while(k<n){
            if(map.containsKey(s.charAt(k))){
                left = Math.max(left,map.get(s.charAt(k)) + 1);
            }
            map.put(s.charAt(k),k);
            ans = Math.max(ans,k-left+1);
            k++;
        }

        return ans;
    }
    
}
