package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/9 20:45
 */
public class case2139 {
    public static void main(String[] args) {
        int i = new case2139().minMoves(10, 4);
        System.out.println("i = " + i);

    }
    public int minMoves(int target, int maxDoubles) {
        int cnt = 30, one_cnt = 0;
        Integer in = (1<<cnt);
        for(int i=1;i<=31;i++){
            System.out.println("left <<   " + i +" : "+  Integer.toBinaryString(1<<i));
        }
        System.out.println("   int min << "+Integer.toBinaryString(Integer.MIN_VALUE ));
        System.out.println("left    << "+Integer.toBinaryString(in));
        System.out.println("int max << "+Integer.toBinaryString(Integer.MAX_VALUE ));
        System.out.println("int max << "+ (Integer.MAX_VALUE));
        System.out.println("int max << "+ (Integer.MAX_VALUE+3));
        System.out.println("left 30 <<  "+ in);
        System.out.println("left 31 << "+ (1<<31));
        System.out.println("left 31 -1 << "+ ((1<<31)-1));
        System.out.println("target<< "+Integer.toBinaryString(target));

        while (((1 << cnt) & target) == 0) cnt--;
        cnt = Math.min(maxDoubles, cnt);
        System.out.println("cnt = " + cnt);
        for (int i = 0; i < cnt; i++) {
            if ((target & 1) != 0) one_cnt += 1;
            target >>= 1;
            System.out.println("target>> "+Integer.toBinaryString(target));
        }
        return target - 1 + cnt + one_cnt;
    }
}
