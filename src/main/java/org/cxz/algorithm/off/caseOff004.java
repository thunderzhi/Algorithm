package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/17 11:11
 */
public class caseOff004 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if(n==0) return false;
        int m = matrix[0].length;
        int col = m-1,row = 0;
        while(col>=0&&col<=m-1&&row>=0&&row<=n-1){
            int num = matrix[row][col];
            if(num == target) return true;
            if( num > target ){
                col--;
            }
            else if( num < target){
                row++;
            }
        }
        return false;
    }
}
