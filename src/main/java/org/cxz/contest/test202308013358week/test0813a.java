package org.cxz.contest.test202308013358week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/13 10:11
 */
public class test0813a {
    public int maxSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n ; i++) {
            int x = nums[i],max = 0,m = 0;
            while(x>0){
                m = x%10;
                x /=10;
                max = Math.max(max,m);
            }
            if(!map.containsKey(max)) map.put(max,new ArrayList<>());
            List<Integer> list = map.get(max);
            list.add(nums[i]);
            map.put(max,list);
        }
        int ans =-1;
        for(int k :map.keySet()){
            List<Integer> list = map.get(k);
            if(list.size()<2)continue;
            Collections.sort(list,(a,b)->{return b-a;});
            ans = Math.max(ans,list.get(0)+list.get(1));
        }
        return ans;
    }
}
