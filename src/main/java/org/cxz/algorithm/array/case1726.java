package org.cxz.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/19 13:53
 */
public class case1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        int n = nums.length;
        for(int i = 0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                int x = nums[i]*nums[j];
                map.put(x, map.getOrDefault(x,0)+1);
            }
        }
        int ans = 0 ;
        for(int k : map.keySet()){
            int c = map.get(k);
            if(c==1) continue;
            //0~c-1
            ans += 4*(c-1)*c;
        }
        return ans;
    }
}
