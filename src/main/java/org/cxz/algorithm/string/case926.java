package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/24 15:22
 */
public class case926 {

    //ver greedy
    public int minFlipsMonoIncr(String s) {
        int cnt0=0,cnt1 =0;
        int ans =0;
        for(int i = 0;i <s.length();i++){
            if(s.charAt(i)=='0'){
                cnt0++;
            }
        }
        ans  = cnt0;

        for(int i = 0;i <s.length();i++){
            if(s.charAt(i)=='1'){
                cnt1+=1;
            }
            else{
                cnt0-=1;
            }
            ans = Math.min(ans ,cnt0+cnt1);
        }
        return ans;
    }

    // ver2 2d dp
    public int minFlipsMonoIncr2(String s) {
        /*
        dp[i][0]   ith is 0 min cost
        dp[i][0] = dp[i-1][0] + s[i]==0?0:1;
        dp[i][1]   ith is 1 min cost
        dp[i][1]  =min( dp[i-1][0],dp[i-1][1])+s[i]==1?0:1;

        */
        int n = s.length();
        int[][] dp = new int[n+1][2];
        dp[1][0]= s.charAt(0)=='0'?0:1;
        dp[1][1]= s.charAt(0)=='1'?0:1;
        // System.out.println("i:"+1+"|0:"+dp[1][0]);
        // System.out.println("i:"+1+"|1:"+dp[1][1]);
        for (int i = 2; i <= s.length(); i++) {
            dp[i][0]= dp[i-1][0] + (s.charAt(i-1)=='0'?0:1);
            dp[i][1]  =Math.min(dp[i-1][0],dp[i-1][1])+(s.charAt(i-1)=='1'?0:1);
            // System.out.println("i:"+i+"|0:"+dp[i][0]);
            // System.out.println("i:"+i+"|1:"+dp[i][1]);
        }
        return Math.min(dp[n][0],dp[n][1]);
    }

    // ver3 2d dp 2
    public int minFlipsMonoIncr3(String s) {
        int n = s.length();
        int[][] dp = new int[2][2];
        dp[1][0]= s.charAt(0)=='0'?0:1;
        dp[1][1]= s.charAt(0)=='1'?0:1;
        for (int i = 2; i <= s.length(); i++) {
            int ind = i%2;
            int preind = ind==1?0:1;
            dp[ind][0]= dp[preind][0] + (s.charAt(i-1)=='0'?0:1);
            dp[ind][1]  =Math.min(dp[preind][0],dp[preind][1])+(s.charAt(i-1)=='1'?0:1);
        }
        return Math.min(dp[n%2][0],dp[n%2][1]);
    }

    // ver4 1d dp 2
    public int minFlipsMonoIncr4(String s) {
        int n = s.length();
        int[] dp = new int[2];
        dp[0]= s.charAt(0)=='0'?0:1;
        dp[1]= s.charAt(0)=='1'?0:1;
        for (int i = 1; i < s.length(); i++) {
            dp[1]= Math.min(dp[0],dp[1])+(s.charAt(i)=='1'?0:1);
            dp[0]= dp[0] + (s.charAt(i)=='0'?0:1);
        }
        return Math.min(dp[1],dp[0]);
    }

}
