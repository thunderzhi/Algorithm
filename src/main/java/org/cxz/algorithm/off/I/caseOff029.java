package org.cxz.algorithm.off.I;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/6 23:49
 */
public class caseOff029 {

    //region ver1
    //ver 1
    public int m,n;
    public List<Integer> arr;
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return new int[0];
        m = matrix.length;
        n = matrix[0].length;
        arr = new ArrayList();
        clockwisely(matrix,m,n);
        int[] ans = arr.stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }

    public void clockwisely(int[][] mat,int row,int col){
        if(row<=0||col<=0) return;
        int start =0;
        while(row>2*start&&col>2*start){
            cycle(mat,row,col,start);
            start++;
        }
    }

    public void cycle(int[][] mat,int row,int col,int start){
        int endcol= col -1 - start;
        int endrow= row -1 - start;
        for(int i = start;i<=endcol;i++){
            arr.add(mat[start][i]);
        }

        if(start<endrow){
            for(int i = start+1;i<=endrow;i++){
                arr.add(mat[i][endcol]);
            }
        }
        if(start<endrow&&start<endcol){
            for(int i = endcol-1;i>=start;i--){
                arr.add(mat[endrow][i]);
            }
        }
        if(start<endcol&&start<endrow-1){
            for(int i = endrow-1;i>=start+1;i--){
                arr.add(mat[i][start]);
            }
        }
    }
    //endregion

    //ver2
    public int[] spiralOrder2(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, x = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while(true) {
            for(int i = left; i <= right; i++) {
                res[x++] = matrix[top][i]; // left to right.
            }
            top++;
            if(top > bottom) break;
            for(int i = top; i <= bottom; i++) {
                res[x++] = matrix[i][right]; // top to bottom.
            }
            right--;
            if(left > right) break;
            for(int i = right; i >= left; i--) {
                res[x++] = matrix[bottom][i]; // right to left.
            }
            bottom--;
            if(top > bottom) break;
            for(int i = bottom; i >= top; i--) {
                res[x++] = matrix[i][left]; // bottom to top.
            }
            left++;
            if(left > right) break;
        }
        return res;
    }



}
