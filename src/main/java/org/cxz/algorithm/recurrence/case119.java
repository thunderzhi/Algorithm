package org.cxz.algorithm.recurrence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/5 16:53
 */
public class case119 {
    public static void main(String[] args) {
        int a = 4;
        List<Integer> row = new case119().getRow2(a);

        System.out.println("row.toString() = " + row.toString());
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if(rowIndex == 0){
            ans.add(1);
            return ans;
        }
        if(rowIndex == 1){
            ans.add(1);
            ans.add(1);
            return ans;
        }
        int[][] dp = new int[rowIndex+1][rowIndex+1];
        dp[0][0] = 1;
        dp[1][0] =1;
        dp[1][1] =1;
        for (int i = 2; i < dp.length; i++) {
            dp[i][0]=1;
            dp[i][i] =1;
            for (int j = 1; j < i; j++) {
                //Dp[i][j] = dp[i-1][j-1]+dp[i-1][j],
                dp[i][j] =dp[i-1][j-1]+dp[i-1][j];
            }
        }

        for (int i = 0; i <= rowIndex; i++) {
            ans.add(dp[rowIndex][i]);
        }
        return ans;
    }

    //only use 2 int[]
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if(rowIndex == 0){
            ans.add(1);
            return ans;
        }
        if(rowIndex == 1){
            ans.add(1);
            ans.add(1);
            return ans;
        }
        int[][] dp = new int[2][rowIndex+1];
        dp[0][0] = 1;
        dp[1][0] =1;
        dp[1][1] =1;
        for (int i = 2; i <= rowIndex; i++) {
            int ind = i%2;
            int preind = (ind==1?0:1);
            dp[ind][0]=1;
            //dp[i][i] =1;
            for (int j = 1; j <= i; j++) {
                //Dp[i][j] = dp[i-1][j-1]+dp[i-1][j],
                dp[ind][j] =dp[preind][j-1]+dp[preind][j];
            }
        }

        for (int i = 0; i <= rowIndex; i++) {
            ans.add(dp[rowIndex%2][i]);
        }
        return ans;
    }

    //only use int[]
    public List<Integer> getRow3(int rowIndex){
        int[] dp = new int[rowIndex+1];
        dp[0] =1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j>0 ; j--) {
                dp[j] = dp[j-1]+dp[j];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            ans.add(dp[i]);
        }
        return ans;

    }
}
