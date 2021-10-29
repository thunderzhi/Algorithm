package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/29 11:13
 */
public class case240 {

    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col-1;
        while(i<row&&j>=0){
            int base = matrix[i][j];
            if(base== target){
                return true;
            }
            if(base>target){
                j--;
            }
            else{
                i++;
            }
        }

        return false;
    }
}
