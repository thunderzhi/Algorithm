package org.cxz.algorithm.dp;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/25 17:28
 */
public class case032 {
    public static void main(String[] args) {

    }

    public int longestValidParentheses(String s) {
        int ans =0;
        int n = s.length();
        int[] dp = new int[n+3];
        dp[0] =0;
        for (int i = 1,I=i+2; i < s.length(); i++,I++) {
            char c = s.charAt(i);
            if(c=='('){
                continue;
            }
            if(s.charAt(i-1)=='('){
                dp[I] = dp[I-2]+2;
            }
            else{
                int j = i-dp[I-1]-1;
                if(j<0||s.charAt(j)==')'){
                    //cant get longer
                    continue;
                }
                dp[I]= dp[I-1]+2+dp[j-1+2];
            }
            ans = Math.max(ans,dp[I]);

        }
        return ans;
    }
}
