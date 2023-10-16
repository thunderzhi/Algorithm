package org.cxz.contest.test20231014367week;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/14 23:58
 */
public class test1015c {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int[] ans = new int[]{-1,-1};
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        // abs(ai -aj)>=val
        // if ai>=aj  ai-aj>=val, find ai-val>=aj
        // if ai<aj   aj-ai>=val,    find ai+val<=aj
        for (int i = indexDifference; i <n ; i++) {
            if(indexDifference==0&&valueDifference==0){
                return new int[ ]{0,0};
            }
            tm.put(nums[i-indexDifference],i-indexDifference);
            int k1 = nums[i] - valueDifference;
            if(tm.floorKey(k1)!=null){
                int f = tm.floorKey(k1);
                ans[1] = i; ans[0] = tm.get(f);
                return ans;
            }
            int k2 = nums[i]+valueDifference;
            if(tm.ceilingKey(k2)!=null){
                int c = tm.ceilingKey(k2);
                ans[1] = i; ans[0] = tm.get(c);
                return ans;
            }
        }
        return ans;
    }
}
