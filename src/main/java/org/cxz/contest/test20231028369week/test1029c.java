package org.cxz.contest.test20231028369week;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/28 21:44
 */
public class test1029c {

    public long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        // n = 3 4 5      3/3 = 1
        // n = 6 7 8      6/3 = 2
        // f[i][0] 第i个数不动，可以符合条件的最小操作
        // 1 第i-1个数 动了， or  第i-2个数动了
        // 2 第i-1个数没动 但是达标，第i-2个数没动 但是达标，
        // f[i][0] = f[i-1][1], or f[i-2][1]
        // f[i][0] = (nums[i-1-1]>=k?f[i-1][0]) , or (nums[i-2-1]>=k?f[i-2][0])
        // f[i][1] = (nums[i-1]>=k? 0: k - nums[i-1] )
        // +min(f[i-1][1],f[i-2][1],f[i-1][0] ,f[i-2][0] )
        // +min(f[i-1][1],f[i-1][0] ,f[i-2][0] )
        long INF = Long.MAX_VALUE/2;
        long[][] f = new long[n+1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i],INF);
        }
        f[1][0] = (nums[0]>=k)?0:INF;
        f[1][1] = (nums[0]>=k)?0:(k-nums[0]);
        Deque<Integer> q0 = new ArrayDeque<>();
        Deque<Integer> q1 = new ArrayDeque<>();
        q0.offerLast(1);
        q1.offerLast(1);
        for (int i = 2; i <= n; i++) {
            int cur = nums[i-1];
            int op = cur>=k?0:(k-cur);
            long min0 = f[q0.peekFirst()][0];
            long min1 = f[q1.peekFirst()][1];
            f[i][0] = Math.min(f[i][0],min1);
            for (int j = i-1; j >i-3&&j>=1 ; j--) {
                if(nums[j-1]>=k) f[i][0] = Math.min(f[i][0],f[j][0]);
            }
            f[i][1] = Math.min(f[i-1][1],min0)+op;
            while(!q0.isEmpty()&&(i-q0.peekFirst()>2)) q0.pollFirst();
            while(!q0.isEmpty()&&f[q0.peekLast()][0]>f[i][0]){
                q0.pollLast();
            }
            q0.offerLast(i);
            while(!q1.isEmpty()&&(i-q1.peekFirst()>2)) q1.pollFirst();
            while(!q1.isEmpty()&&f[q1.peekLast()][1]>f[i][1]){
                q1.pollLast();
            }
            q1.offerLast(i);
        }
        return Math.min(f[n][0],f[n][1]);
    }
}
