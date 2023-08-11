package org.cxz.algorithm.matrix;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/11 22:16
 */
public class case1572 {

    public int diagonalSum(int[][] mat) {
        int sum = 0,n = mat.length,mid = n/2;
        if(n==1)return mat[0][0];
        for(int i = 0;i<n;i++){
            sum += mat[i][i]+ mat[i][n-1-i];
        }
        return (n&1)==0?sum:sum - mat[mid][mid];
    }
}
