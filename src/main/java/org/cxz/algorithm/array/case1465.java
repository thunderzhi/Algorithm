package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/27 10:26
 */
public class case1465 {


    public int maxArea(int h, int w, int[] hs, int[] vs) {
        int MOD = (int)1e9+7;
        Arrays.sort(hs);
        Arrays.sort(vs);
        int n = hs.length, m = vs.length;
        int mh = Math.max(hs[0], h - hs[n - 1]), mv = Math.max(vs[0], w - vs[m - 1]);
        for (int i = 1; i < n; i++) mh = Math.max(mh, hs[i] - hs[i - 1]);
        for (int i = 1; i < m; i++) mv = Math.max(mv, vs[i] - vs[i - 1]);
        return (int)((mh * 1L * mv) % MOD);
    }

}
