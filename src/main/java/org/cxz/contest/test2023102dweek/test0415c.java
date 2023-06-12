package org.cxz.contest.test2023102dweek;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/15 22:27
 */
public class test0415c {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        long score =0,max = nums[0];//,pre = 0;
        for (int i = 0; i <n ; i++) {
            max = Math.max(max,nums[i]);
            long convert = nums[i] + max;
            score += convert; //
//            score = cur;
//            pre += convert;
            ans[i] = score;
        }
        return ans;

    }
}
