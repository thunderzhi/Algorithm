package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/30 18:14
 */
public class case2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int ans = 0,n = plantTime.length;
        List<int[]> list = new ArrayList();
        for(int i = 0;i<n;i++){
            int[] t = new int[]{plantTime[i],growTime[i]};
            list.add(t);
        }
        Collections.sort(list,(a, b)->{
            return b[1]-a[1];
        });
        int cost = 0;
        for(int[] t: list){
            cost+= t[0];
            ans = Math.max(ans,cost+t[1]);
        }
        return ans;
    }
}
