package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/1 14:49
 */
public class case1333 {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList();
        for(int [] rest: restaurants){
            if(rest[3]>maxPrice||rest[4]>maxDistance) continue;
            if(veganFriendly==0){
                list.add(rest);
                continue;
            }
            if(rest[2]==1) list.add(rest);
        }
        Collections.sort(list, (a, b)->{
            if(b[1]==a[1]){
                return b[0]-a[0];
            }
            return b[1] -a[1];
        });
        List<Integer> ans = new ArrayList();
        for(int[] item :list){
            ans.add(item[0]);
        }
        return ans;
    }
}
