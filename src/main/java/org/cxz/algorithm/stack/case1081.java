package org.cxz.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/9 22:21
 */
public class case1081 {
    public static void main(String[] args) {

    }

    public String smallestSubsequence(String s) {
        int[] cnt = new int[26];
        boolean[] h = new boolean[26];
        Deque<Character> qu = new ArrayDeque<>();
        for(int i= 0;i<s.length();i++){
            char c = s.charAt(i);
            cnt[s.charAt(i)-'a']+=1;
        }
        for(int i= 0;i<s.length();i++){
            char cur = s.charAt(i);
            if(!h[cur-'a']){//miss
                while(!qu.isEmpty()&&qu.peekLast()>cur&&cnt[qu.peekLast()-'a']>0){
                    char c = qu.pollLast();
                    h[c-'a']= false;
                }
                qu.offerLast(cur);
                h[cur-'a']=true;
            }
            cnt[cur-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while(!qu.isEmpty()){
            sb.append(qu.pollFirst());
        }
        return sb.toString();
    }
}
