package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/9 18:22
 */
public class caseOffII094 {
    public static void main(String[] args) {
        String text1 = "aab";

        int i = new caseOffII094().minCut(text1 );
        System.out.println("i = " + i);

    }
    public boolean ispalindrome(String s ,int l,int r){
        while(l<=r){  //miss =  when l==r
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        //dp[i]   endwith i min palindrome   i represent length
        int ans =n;
        dp[0]=0;
        for (int i = 1; i <=n ; i++) {
            dp[i]=i;// each char is parlindrome
            for (int j = 0; j <i ; j++) { //miss j start at 0 ,j<i ,
                if(ispalindrome(s,j,i-1)){
                    dp[i] =Math.min(dp[j]+1,dp[i]);
                }
            }
        }
        return dp[n]-1;
    }
}
