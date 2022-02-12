package org.cxz.algorithm.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/12 16:28
 */
public class case279 {
    public int ans ;
    public int numSquares1(int n) {
        List<Integer> arr =new ArrayList();
        int x = 1;
        int y = 0;
        while(y<=n){
            y= x*x;
            //System.out.println("y:"+y);
            arr.add(y);
            x++;
        }
        ans = n;
        backtrack(arr,0,arr.size()-1,n);
        return ans;
    }

    public void backtrack(List<Integer> nums, int cnt, int right, int target){
        if(target==0) return;
        // while(right>0&&nums.get(right)>target){
        //     right--;
        // }
        if(cnt>=ans) return;
        if(right==0&&ans>cnt+target){
            ans = cnt+target;
            return;
        }
        for(;right>=0;right--){
            int num = nums.get(right);
            //System.out.println("tar:"+target+" num: "+num+" ans: "+ans+" cnt: "+cnt);

            if(num>target) continue;
            int mod = target%num;
            cnt = cnt + target/num;
            if(mod == 0&&cnt<ans){
                ans = cnt;
            }
            backtrack(nums,cnt,right-1,mod);
            cnt = cnt - target/num;
        }
        return;
    }

    // 能用前i个数拼凑出 j的使用数目的最少个数  原始的DP 时间太高
    public int numSquares2(int n) {

        List<Integer> arr = new ArrayList();
        int x = 1;
        int y = 0;
        while(y<=n){
            y = x*x;
            if(y>n){
                break;
            }
            arr.add(y);
            //System.out.println("y: "+y);
            x++;
        }
        int m = arr.size();
        int[][] dp = new int[m+1][n+1];
        //dp[0][0]=1;
        Arrays.fill(dp[0],-1);
        // for(int i = 1;i<=m;i++){
        //     dp[i][1]=1;
        // }
        for(int i = 1;i<=m;i++){
            int val = arr.get(i-1);
            for(int j=1;j<=n;j++){
                dp[i][j]= j;
                //System.out.println("i: "+i+" val :"+val);

                //System.out.println("j: "+j);
                for(int k = 0;k*val<=j;k++){
                    //  System.out.println("k: "+k);
                    //   System.out.println("1 dp i: "+i+"j:"+j+"="+dp[i][j]);
                    //if(i==1) continue;
                    if(dp[i-1][j-k*val]==-1) continue;
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-k*val]+k);
//System.out.println("2 dp i: "+i+"j:"+j+"="+dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    // 1维dp
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0]=0;
        for(int i = 1;i*i<=n;i++){
            for(int j = i*i;j<=n;j++){
                dp[j] = Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];
    }

    //math
    public int numSquares4(int n) {
        if(isSquare(n)) return 1;
        if(check4(n)) return 4;
        for(int i = 1;i*i<n;i++){
            int j = n-i*i;
            if(isSquare(j)){
                return 2;
            }
        }
        return 3;
    }

    public boolean isSquare(int x){
        int y = (int)Math.sqrt(x);
        return y*y==x;
    }

    public boolean check4(int x){
        while(x%4==0){
            x /=4;
        }
        return x%8==7;
    }
}
