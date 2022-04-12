package org.cxz.algorithm.off.I;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/11 21:08
 */
public class caseOff060 {

    public static void main(String[] args) {
        double[] doubles = new caseOff060().dicesProbability(2);
        System.out.println("doubles = " + Arrays.toString(doubles));
    }
    public double[] dicesProbability(int n) {
        double diceNum = 6.0;
        //dp[i][j]
        double[][] dp = new double[n+1][(int)diceNum*n+1];
        for(int i = 1;i<=diceNum;i++){
            dp[1][i] = (double)(1.0/diceNum);
        }
        for(int i = 2;i<=n;i++){
            for(int j = i-1;j<=(i-1)*diceNum;j++ ){
                for (int k = 1; k <=diceNum ; k++) {
                    if(i-1<=0||j+k>diceNum*n)continue;
                    dp[i][j+k] += dp[i-1][j]/diceNum;
                    System.out.println("j: "+j+" k: "+k+" dp["+i+"]["+(j+k)+"] = " +dp[i][j+k] );
                }
            }
        }
//        for (int i = n; i <=(int)diceNum*n ; i++) {
//            System.out.println("dp i = " + i+ " :"+dp[n][i]);
//        }
        double[] ans = new double[(int)diceNum*n-(int)n+1];
        for (int i = 0,k = n; i < ans.length; i++) {
            ans[i] = dp[n][k++];
        }
        return ans;
    }
}
