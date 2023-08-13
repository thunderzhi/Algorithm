package org.cxz.contest.test202308013358week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/13 10:11
 */
public class test0813c {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int y = nums.get(i);
            if(!map.containsKey(y)) map.put(y,new ArrayList<>());
            List<Integer> list = map.get(y);
            list.add(i);
            map.put(y,list);
        }
        int m = map.size(),idx = 0;
        int ans = 1<<30;
        int[] arr = new int[m];
        for(int k: map.keySet()){
            arr[idx++] = k;
            List<Integer> list = map.get(k);
            //Collections.sort(list);
            int id1 = list.get(0),id2 = list.get(list.size()-1);
            if(id2-id1>=x) return 0;
            map.put(k,list);
        }
        Arrays.sort(arr);
        for (int l = 0; l < m; l++) {
            List<Integer> llist = map.get(arr[l]);
            if(Math.abs(arr[l+1]-arr[l])>=ans) continue;
            for (int r = l; r <m; r++) {
                if(Math.abs(arr[r]-arr[l])>=ans){
                    // l should move ++;
                    break;
                }// val <ans  maybe
                List<Integer> rlist = map.get(arr[r]);
                if (check(llist,rlist,x)) {
                    ans = Math.abs(arr[r]-arr[l]);
                    break;
                }
            }
        }
        return ans;
    }
    public boolean check(List<Integer> l1 ,List<Integer> l2,int x){
        int left1 = l1.get(0),right1 = l1.get(l1.size()-1);
        int left2 = l2.get(0),right2 = l2.get(l2.size()-1);
        int r = Math.max(right1,right2);
        int l = Math.min(left1,left2);
        return Math.abs(r-l)>=x;
    }
}
