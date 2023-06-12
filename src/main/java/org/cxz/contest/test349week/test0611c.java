package org.cxz.contest.test349week;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/6/4 10:25
 */
public class test0611c {
    Map<Character,Character> map;
    public String smallestString(String s) {
        map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            map.put(c,getpre(c));
        }
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] cnt = new int[26];
        int p = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]!='a') break;
            p++;
        }
        // p point to first not a
        if(p==n){
            System.out.println("p = " + p);
            // all a
            arr[n-1]='z';
            return new String(arr);
        }
        int p2 = p+1;
        while(p2<n&&arr[p2]!='a') p2++;
        int r = p2-1;
        update(arr,p,r);
        return new String(arr);
    }
    public char getpre(char c){
        if(c=='a') return 'z';
        int preidx = c-'a'-1;
        char c1 = (char) (preidx + 'a');
        return c1;
    }
    public void update(char[] arr,int l,int r){
        for (int i = l; i <=r ; i++) {
            arr[i] = map.get(arr[i]);
        }
        return;
    }
}
