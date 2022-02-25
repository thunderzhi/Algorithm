package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/25 15:03
 */
public class case650 {
    //ver 1
    public int minSteps1(int n) {
        if (n == 1) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (is_prime(i)) {
                dp[i] = i;
            }
            else {
                int j = factor(i);
                dp[i] = dp[j] + i / j;
            }
        }

        return dp[n];
    }

    private int factor(int n) {
        for (int i = n - 1; i >= 1; i--) {
            if (n % i == 0) return i;
        }
        return 1;
    }
    private boolean is_prime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    //ver 2
    public int minSteps2(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                if (i % j == 0) {
                    f[i] = Math.min(f[i], f[j] + i / j);
                    f[i] = Math.min(f[i], f[i / j] + j);
                }
            }
        }
        return f[n];
    }
}
