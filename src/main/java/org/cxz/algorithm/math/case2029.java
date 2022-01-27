package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/27 16:15
 */
public class case2029 {

    public boolean stoneGameIX(int[] stones) {
        long[] cnt = new long[3];
        for (int x : stones) {
            cnt[x % 3]++;
        }
        return (cnt[0] % 2 == 0 && (cnt[1] * cnt[2] >= 1) ||
                (cnt[0] % 2 != 0 && Math.abs(cnt[1] - cnt[2]) >= 3));
    }
}
