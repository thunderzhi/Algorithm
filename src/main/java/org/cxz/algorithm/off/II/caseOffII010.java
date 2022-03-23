package org.cxz.algorithm.off.II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/19 18:23
 */
public class caseOffII010 {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap();
        int[] sum = new int[n+1];
        for(int i =0;i<n;i++){
            sum[i+1] = sum[i]+ nums[i];
        }
        int ans = 0;

        for(int i=0;i<=n;i++){
            int dis = sum[i]-k;
            if(map.containsKey(dis)){
                ans += map.get(dis);
            }
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }
        return ans;
    }
}
