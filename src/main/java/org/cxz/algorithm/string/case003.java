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
    //slide window
    // this window is autosize window,
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
        int right = 0;// window right index
        int left = 0;// window left index
        while(right<n){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left,map.get(s.charAt(right)) + 1);// if not the first time meet the char ,move left pos
            }
            map.put(s.charAt(right),right);//record the latest value of index of char
            ans = Math.max(ans,right-left+1);
            right++;
        }

        return ans;
    }

    
}
