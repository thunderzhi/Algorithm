package org.cxz.algorithm.recurrence;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/19 13:15
 */
public class case1155 {


    //ver1
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        int mod =(int)(1e9+7);
        dp[0][0]=1;
        //dp[i][j]= dp[i-1][j-k1]+dp[i-1][j-k2]+dp[i-1][j-k3]……+dp[i-1][j-kn];
        for(int i =1;i<=n;i++){
            for(int j =1;j<=target;j++){
                for(int m =1;m<=k;m++){
                    if(j-m>=0){
                        dp[i][j] = (dp[i][j]+dp[i-1][j-m])%mod;
                    }
                }
            }
        }
        return dp[n][target];
    }

    //ver 2
    public int numRollsToTarget2(int n, int k, int target) {
        int[][] dp = new int[2][target+1];
        int mod =(int)(1e9+7);
        dp[0][0]=1;
        //dp[i][j]= dp[i-1][j-k1]+dp[i-1][j-k2]+dp[i-1][j-k3]……+dp[i-1][j-kn];
        for(int i =1;i<=n;i++){
            int ind = i%2;
            int preind = ind ==1?0:1;
            Arrays.fill(dp[ind],0);
            for(int j =1;j<=target;j++){
                for(int m =1;j-m>=0&&m<=k;m++){
                    dp[ind][j] = (dp[ind][j]+dp[preind][j-m])%mod;
                }
            }
        }
        return dp[n%2][target];
    }

    public int numRollsToTarget3(int n, int k, int target) {
        // n  ~ n*k
        if(target>n*k||target<n) return 0;
        long mod = (long)1e9+7;
        // f[i][j] 前 i个 得到 和为j 的方案数
        // f[i][j] = f[i-1][j-1]+f[i-1][j-2]..+ f[i-1][j-k]
        // (1,1) =1 (1,1~k) =1
        //(1,1) = (0,0)+(0,-1)
        //(1,2) = (0,1)+(0,0)
        long[][] f = new long[n+1][target+1];
        f[0][0]=1;
        for(int i = 1;i<=n;i++){
            for(int j =i;j<=Math.min(i*k,target);j++){
                for(int q = 1;q<=k;q++){
                    if(j-q<0) break;

                    f[i][j] += f[i-1][j-q];
                    f[i][j] %= mod;
                }
            }
        }
        return (int)( f[n][target]%mod);
    }

}
