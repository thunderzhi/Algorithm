package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/19 11:45
 */
public class case289 {


    //ver 1
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] mark = new int[rows][cols];
        int[][] dir ={{0,1},{1,0},
                {-1,0},{0,-1},
                {1,-1},{-1,1},
                {-1,-1},{1,1}};//miss dir
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                for(int k = 0;k<8;k++){
                    int x = i+dir[k][0];
                    int y = j+dir[k][1];
                    if(x>=0&&x<rows&&y>=0&&y<cols){
                        mark[i][j]+=board[x][y];
                    }
                }
            }
        }

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(board[i][j]==1){//live
                    if(mark[i][j]<2||mark[i][j]>3){
                        board[i][j]=0;
                    }
                }
                else{//dead
                    if(mark[i][j]==3){
                        board[i][j]=1;
                    }
                }
            }
        }
    }
}
