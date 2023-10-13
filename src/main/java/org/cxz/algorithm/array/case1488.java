package org.cxz.algorithm.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/13 11:08
 */
public class case1488 {

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        TreeSet<Integer> set = new TreeSet();
        Map<Integer,Integer> map = new HashMap();
        int[] ans = new int[n];
        for(int i =0;i<n;i++){
            int r = rains[i];
            if(r==0){
                set.add(i);
                continue;
            }
            if(map.containsKey(r)){
                Integer c = set.ceiling(map.get(r));
                if(c==null) return new int[0];
                ans[c] =r;
                set.remove(c);
            }
            ans[i] =-1;
            map.put(r,i);
        }
        for(int k :set) ans[k] = 1;
        return ans;
    }
}
