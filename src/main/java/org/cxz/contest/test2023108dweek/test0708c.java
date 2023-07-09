package org.cxz.contest.test2023108dweek;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/8 22:27
 */
public class test0708b {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)) continue;
            map.put(num,1);
        }
        int n = moveFrom.length;
        for (int i = 0; i < n; i++) {
            int fromidx = moveFrom[i];
            int toidx = moveTo[i];
            map.remove(fromidx);
            if(!map.containsKey(toidx)){
                map.put(toidx,1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int key :map.keySet()){
            list.add(key);
        }
        Collections.sort(list);
        return list;
    }
}
