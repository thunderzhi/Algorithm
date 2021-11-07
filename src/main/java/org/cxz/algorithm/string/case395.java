package org.cxz.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/7 22:59
 */
public class case395 {
    public static void main(String[] args) {

    }

    public int longestSubstring(String s, int k) {
        if(s==null){
            return 0;//miss
        }
        if(s.length()<k){
            return 0;//miss
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.get(c)<k){
                list.add(i);
            }
        }
        list.add(s.length());//miss

        if(list.size()==1){
            return s.length();//miss
        }
        int ans =0;
        int pre =0;
        for(int i = 0;i<list.size();i++){
            int p = list.get(i);
            //p-1+ pre +1 =p-pre
            if(p-pre>=k){
                int t = longestSubstring(s.substring(pre,p),k);

                ans = Math.max(ans,t);
            }
            pre=p+1;
        }
        return ans;
    }
}
