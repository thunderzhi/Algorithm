package org.cxz.algorithm.recurrence;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/10 10:56
 */
public class case474 {
    public static void main(String[] args) {
        String[] arr = {"10", "0001", "111001", "1", "0"};
        int maxForm = new case474().findMaxForm(arr, 5, 5);
        System.out.println("maxForm = " + maxForm);
    }

    public int get0cnt(String s){
        int cnt=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0'){
                cnt++;
            }
        }
        return cnt;
    }

    //ver 1 3d array
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];//
        dp[0][0][0]=0;
        int length = strs.length;

        for (int i = 1; i <=length ; i++) {//miss =
            int lstr = strs[i-1].length();//miss = str[0]
            int cntstr0 = 0;int cntstr1= 0;
            cntstr0 = get0cnt(strs[i-1]);
            cntstr1 =lstr-cntstr0;
            System.out.println("cntstr1 = " + cntstr1+" cntstr0 = " + cntstr0);
            for (int j = 0; j <=m; j++) {// miss 0
                for (int k = 0; k <=n; k++) {// miss 0
                    dp[i][j][k] = dp[i-1][j][k];
                    System.out.println("1 dp[i][j][k]= " + dp[i][j][k]);

                    if(j>=cntstr0&&k>=cntstr1){
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - cntstr0][k - cntstr1] + 1);
                        System.out.println("2 dp[i][j][k]= " + dp[i][j][k]);

                    }
                }
            }
        }
        return dp[length][m][n];
        /*
        dp[i][m][n] = repesent  0~~i contain m of zero and n of one MAX
        if contain i
        dp[i][m][n] = dp[i-1][m-strs[i]ZeroCNT][n--strs[i]OneCNT]+1
        if not contain i
        dp[i][m][n] =dp[i-1][m][n]
        max(1,2)

        * */
    }
}
