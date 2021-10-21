package org.cxz.algorithm.unionfind;

import java.util.concurrent.ForkJoinPool;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/21 11:17
 */
public class case547 {
    public static void main(String[] args) {



    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;//row
        int m = isConnected[0].length;//column
        UnionSet u = new UnionSet(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(isConnected[i][j]==1){
                    u.merge(i,j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(u.get(i)==i){
                ans+=1;
            }
        }
        return ans;
    }
}