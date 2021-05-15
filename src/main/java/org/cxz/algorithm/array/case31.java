package org.cxz.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/15 15:23
 */
public class case31 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            int t = target- nums[i];
            if(map.containsKey(t)&&i!=map.get(t)){
                return new int[]{i,map.get(t)};
            }
        }
        return new int[]{};

    }
}
