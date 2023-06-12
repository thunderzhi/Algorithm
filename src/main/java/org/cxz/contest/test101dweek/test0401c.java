package org.cxz.contest.test101dweek;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/1 22:27
 */
public class test0401b {
    public static void main(String[] args) {
        String s = "talaqlt";
        String chars = "tqla";
        int res = maximumCostSubstring(s, chars, new int[]{4, 3, 3, -2});
        System.out.println("res = " + res);
    }
    public static int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            map.put(c-'a',vals[i]);
        }
        // q 16-3  a 0- -2  t 19-4 l 11-3
        int n = s.length();
        for (int i = 0; i <26 ; i++) {
            if(map.containsKey(i)) continue;
            map.put(i,i+1);
        }
        ////
        int[] sum = new int[n+1];
        int min = 0;//Math.min(0,map.get(s.charAt(0)-'a'));
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1]+map.get(s.charAt(i-1)-'a');
            ans = Math.max(ans,sum[i]-min);
            min = Math.min(min,sum[i]);
        }
        return ans;
    }
}
