package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/5/1 12:19
 */
public class case2226 {

    public int maximumCandies(int[] candies, long k) {
        long l = 0, r = Arrays.stream(candies).max().getAsInt();
        while (l < r) {
            long mid = (l + r + 1) >> 1;
            if (check(candies, mid) < k) r = mid - 1;
            else l = mid;
        }
        return (int) l;
    }
    public long check(int[] candies, long x) {
        long ans = 0;
        for (int candy : candies) {
            ans += candy / x;
        }
        return ans;
    }
}
