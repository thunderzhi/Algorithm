package org.cxz.contest.test323week;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/11 10:31
 */
public class test1211c {


    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int max =0;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            max = Math.max(max, nums[i]);
        }
        Arrays.sort(nums);
        Set<Integer> vis = new HashSet<>();
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if(vis.contains(nums[i])) continue;
            int len = 0;
            int x = nums[i];
            while(x<=max){
                if(!set.contains(x)){
                    break;
                }
                vis.add(x);
                x *=2;
                len++;
            }
            if(len>1&&len>ans){
                ans = len;
            }
        }
        return ans;
    }
}
