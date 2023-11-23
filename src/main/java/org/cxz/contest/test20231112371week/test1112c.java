package org.cxz.contest.test20231112371week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/12 10:29
 */
public class test1112b {

    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String,List<Integer>> map = new HashMap<>();
        for(List<String> list: access_times){
            String name = list.get(0);
            String tstr = list.get(1);
            int h = Integer.parseInt(tstr.substring(0,2));
            int m = Integer.parseInt(tstr.substring(2,4));
            int time = h*60+m;
            if(!map.containsKey(name)) map.put(name,new ArrayList<>());
            List<Integer> list1 = map.get(name);
            list1.add(time);
        }
        List<String> ans = new ArrayList<>();
        for (String k : map.keySet()){
            List<Integer> list = map.get(k);
            if(list.size()<3) continue;
            Collections.sort(list);
            if( check(list)) ans.add(k);
        }
        return ans;
    }
    public boolean check(List<Integer> arr){
        if(arr.size()<3) return false;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.size(); i++) {
            int curtime = arr.get(i);
            while(!queue.isEmpty()&&(curtime - queue.peekFirst())>=60){
                queue.pollFirst();
            }
            queue.offerLast(curtime);
            if(queue.size()>=3) return true;
        }
        return false;
    }
}
