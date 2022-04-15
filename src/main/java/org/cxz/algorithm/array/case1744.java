package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/15 16:51
 */
public class case1744 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] sum = new long[n];
        for(int i = 1;i<n;i++){
            sum[i] = candiesCount[i-1] + sum[i-1];
        }
        boolean[] ans = new boolean[queries.length];
        for(int i = 0;i<queries.length;i++){
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];
            if(sum[type]<day+1-candiesCount[type]){
                ans[i] = false;
            }
            else if(sum[type]/cap>=(day+1)){
                ans[i] = false;
            }
            else{
                ans[i]= true;
            }
        }
        return ans;
    }
}
