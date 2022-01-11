package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/11 11:55
 */
public class case494 {
    public static void main(String[] args) {

    }

    public int findTargetSumWays(int[] nums, int target) {
        /*
        f[i][j] = f[i − 1][j − x] + f[i − 1][j + x]
        f[ind][j + x] += f[pre_ind][j];
        f[ind][j - x] += f[pre_ind][j];
        f[i][j + x] =f[i][j + x] + f[i-1][j];
        f[i][j - x] =f[i][j - x] + f[i-1][j];
        * */
       // int[][] dp =

        return 1;
    }
}
