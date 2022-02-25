package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/25 16:53
 */
public class case1039 {
    public static void main(String[] args) {
        int[] a = new int[]{ 1,3,1,4,1,5};
        new case1039().minScoreTriangulation(a);

    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            System.out.println("--------"+len+"-----------");
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                System.out.println("-------------------");
                dp[i][j] = Integer.MAX_VALUE;
                System.out.println("dp["+i+"]["+j+"]: "+dp[i][j]);
                for (int k = i + 1; k < j; k++) {
                    System.out.println("multi i*j*k: "+values[i] * values[j] * values[k]);
                    System.out.println("dp["+i+"]["+k+"]: "+dp[i][k]);
                    System.out.println("dp["+k+"]["+j+"]: "+dp[k][j]);
                    System.out.println("dp["+i+"]["+k+"] + dp["+k+"]["+j+"] + multi ijk ="
                            +dp[i][k]+" + "+dp[k][j]+" +  "+values[i] * values[j] * values[k]);

                    dp[i][j]
                            = Math.min(values[i] * values[j] * values[k]
                            + dp[i][k] + dp[k][j], dp[i][j]);
                    System.out.println("set dp["+i+"]["+j+"]: "+dp[i][j]);

                }
            }
        }
        return dp[0][n - 1];
    }
}
