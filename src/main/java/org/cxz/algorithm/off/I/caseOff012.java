package org.cxz.algorithm.off.I;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/15 22:21
 */
public class caseOff012 {
 
    public int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean[][] mark;
    public int m,n;
    public boolean exist(char[][] board, String word) {
        //dir = {{0,1},{1,0},{0,-1},{-1,0}};
        char[] arr = word.toCharArray();
        m = board.length;
        n = board[0].length;
        mark = new boolean[m][n];
        List<int[]> begin = new ArrayList();
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==arr[0]){
                    if(find(i,j,board,arr,0)) return true;
                }
            }
        }
        return false;
    }
    public boolean find(int x,int y,
                        char[][] board,char[] arr, int ind){
        if(x<0||x>=m||y<0||y>=n||board[x][y]!=arr[ind]) return false;
        if(mark[x][y]) return false;
        if(board[x][y]==arr[ind]&&ind == arr.length-1) return true;
        mark[x][y] = true;
        for(int k =0;k<4;k++ ){
            int i = x + dir[k][0];
            int j = y + dir[k][1];
            if(i<0||i>=m||j<0||j>=n) continue;
            if(mark[i][j]) continue;
            if(find(i,j,board,arr,ind+1)) return true;
        }
        mark[x][y] = false;
        return false;
    }
}
