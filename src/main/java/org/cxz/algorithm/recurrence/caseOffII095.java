package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/9 18:22
 */
public class caseOffII095 {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int i = new caseOffII095().longestCommonSubsequence(text1, text2);
        System.out.println("i = " + i);

    }

    public int longestCommonSubsequence(String text1, String text2) {
        String A = text1;  // A is longer
        String B = text2;

        int lengthA = text1.length();
        int lengthB = text2.length();
        int[][] dp = new int[lengthA+1][lengthB+1];

        for (int i = 1; i <= lengthA; i++) {
            for (int j = 1; j <=lengthB ; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);   //miss dp[i-1][j]
                //System.out.println("1 dp["+i+"]["+j+"] = " + dp[i][j]);
                if( A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);//miss dp[i-1][j-1]
                    //System.out.println("2 dp["+i+"]["+j+"] = " + dp[i][j]);

                }
            }
        }
        return dp[lengthA][lengthB];

        //dp[i][j]  A endwith i  B endwith j  the longest size
        /*
        dp[i][j] = dp[i][j-1]     a[i]!= b[j]

        dp[i][j] = dp[i][j-1]                a[i]== b[j]


        * */




    }
}
