package org.cxz.algorithm.matrix;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/25 16:10
 */
public class case079 {

    public int[][] dir;
    public boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        vis = new boolean[m][n];
        for(int i =0 ;i<m ;i++){
            for(int j = 0;j<n;j++){
                if(word.charAt(0)==board[i][j]&&
                        find(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, String word,int ind,int row,int col){
        if(ind == word.length()-1&&board[row][col]==word.charAt(ind)) return true;
        if(board[row][col]!=word.charAt(ind)) return false;
        int m = board.length;
        int n = board[0].length;
        for(int i =0 ;i<dir.length;i++){
            int x = row + dir[i][0];
            int y = col + dir[i][1];
            if(x>=m||x<0) continue;
            if(y>=n||y<0) continue;
            if(vis[x][y]) continue;
            vis[row][col] = true;
            if(find(board,word,ind+1,x,y)) return true;
            vis[row][col] = false;
        }
        return false;
    }
}
