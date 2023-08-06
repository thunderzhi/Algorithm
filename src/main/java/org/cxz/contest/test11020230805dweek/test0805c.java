package org.cxz.contest.test11020230805dweek;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/5 20:08
 */
public class test0805c {
    // pass  another idea
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int x =nums.get(i);
            if(!map.containsKey(x)){
                map.put(x,new ArrayList<>());
            }
            List<Integer> list = map.get(x);
            list.add(i);
            map.put(x,list);
        }
        //System.out.println("map size "+map.size());
        int ans = n;
        if(map.size()==1) return 0;
        if(map.size()==n) return n/2;

        for(int key : map.keySet()){
            List<Integer> list = map.get(key);
            int time = n-1;
            if(list.size()==1){
                ans = Math.min(ans,n/2);
                continue;
            }
            int cost = 0,size = list.size();
            for (int i = 0; i < size-1 ; i++) {
                // 01 12  n-1~0
                int len = 0;
                int a = list.get(i),b = list.get(i+1);
                len = b-a-1;
                cost = Math.max(cost, (len+1)/2);
            }
            int a = list.get(0),b = list.get(size-1);
            int len = n-(b-a+1);
            time = Math.max(cost,(len+1)/2);
            ans = Math.min(ans,time);
        }
        return ans;
    }
}
