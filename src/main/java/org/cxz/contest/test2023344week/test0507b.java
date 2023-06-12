package org.cxz.contest.test2023344week;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/7 10:26
 */
public class test0507a {
    public int[] distinctDifferenceArray(int[] nums) {
        int  n = nums.length;
        int[] ans = new int[n];
        Set<Integer> s1 = new HashSet<>();
        for (int i = 0; i <n ; i++) {
            int cur = nums[i];
            s1.add(cur);
            Set<Integer> s2 = new HashSet<>();
            for (int j = i+1; j < n; j++) {
                s2.add(nums[j]);
            }
            ans[i] = s1.size() - s2.size();
        }
        return ans;
    }
}



