package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/9 20:45
 */
public class case2139 {
    public int minMoves(int target, int maxDoubles) {
        int cnt = 30, one_cnt = 0;
        Integer in = (1<<cnt);
        System.out.println("left<< "+Integer.toBinaryString(in));
        while (((1 << cnt) & target) == 0) cnt--;
        cnt = Math.min(maxDoubles, cnt);
        for (int i = 0; i < cnt; i++) {
            if ((target & 1) != 0) one_cnt += 1;
            target >>= 1;
        }
        return target - 1 + cnt + one_cnt;
    }
}
