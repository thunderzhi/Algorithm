package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/24 12:28
 */
public class case221 {

    //ver 2 dp
    public int maximalSquare2(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int ans = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                dp[i][j] = matrix[i][j]-'0';
                if(i==0||j==0||dp[i][j]==0){
                    ans = Math.max(ans,dp[i][j]*dp[i][j]);
                    // System.out.println("1 ans:"+ans);
                    continue;
                }
                dp[i][j] += Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]);
                ans = Math.max(ans,dp[i][j]*dp[i][j]);
                // System.out.println("2 ans:"+ans);
            }
        }
        return ans;
    }

    // ver1 brute force
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int L = Math.min(m,n);
        int ans = 0;
        for(int l =1;l<=L;l++){
            boolean flag = false;
            for(int x =0;x<=m-l;x++){
                for(int y =0;y<=n-l;y++){
                    if(check(l,x,y,matrix))
                    {
                        flag = true;
                        ans = Math.max(ans,l*l);
                        break;
                    }
                }
                if(flag) break;
            }
            if(!flag) break;
        }
        return ans;
    }

    public boolean check(int length,int x,int y,char[][] matrix){
        boolean res = true;
        for(int i = x;i<x+length;i++){
            for(int j = y;j<y+length;j++){
                if(matrix[i][j]=='0'){
                    //System.out.println("l: "+length+" x:"+x+" y:"+y+" res:"+false);
                    return false;
                }
            }
        }
        //System.out.println("l: "+length+" x:"+x+" y:"+y+" res:"+res);
        return res;
    }
}
