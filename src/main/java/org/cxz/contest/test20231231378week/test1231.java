package org.cxz.contest.test20231231378week;

import java.util.*;
import java.util.logging.Handler;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/12/31 10:32
 */
public class test1231 {
    public boolean hasTrailingZeros(int[] nums) {
        boolean res = false;
        int k = 0;
        for (int x : nums) {
            if ((x & 1) == 0) {
                k++;
                if (k > 1) return true;
            }
        }
        return res;
    }



    public int maximumLength(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <26 ; i++) {
            map.put((char)('a'+i),new ArrayList<>());
        }
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] cnt = new int[26];
        int ans =-1;
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            int j = i;
            while(j+1<n&&cs[j]==cs[j+1]) j++;
            List<Integer> list = map.get(c);
            list.add(j-i+1); 
            cnt[c-'a']+= j-i+1;
            map.put(c,list);
            i = j;
        }
        // System.out.println("-------- " );
        for(Character key : map.keySet()){
            List<Integer> list = map.get(key);
            if(list.size()==0) continue;
            // System.out.println("key = " + key+ " list "+ list.toString());
            if(cnt[key-'a']<3) continue;
            Collections.sort(list);
            int res = 1,len = list.size();
            Map<Integer,Integer> tm = new HashMap<>();
            for (int i = len - 1; i >=0 ; i--) {
                int x = list.get(i);
                int k = 1;
                while(x>=res){
                    tm.put(x,tm.getOrDefault(x,0)+k);
                    int v = tm.get(x);
                    // System.out.println(" key = " + key+ " i "+ i + " range "+ x+" v "+ v+" res "+ res);
                    x--;k++;
                    if(v>2 ){
                        res =  Math.max(x+1,res);
                    }
                }
            }
            if(res>0) ans = Math.max(ans,res);
        }
        return ans;
    }
}
