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

    //ver 2
    public void gameOfLife2(int[][] board) {
        //2 is live to die
        // 0 is dead, 1 is live
        // 2 is live to die  , 3 is die to live
        int[][] dir = {{1,0},{0,1},
                {-1,0},{0,-1},
                {1,1},{-1,-1},
                {-1,1},{1,-1},
        };
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt=0;
                for (int k = 0; k < 8; k++) {
                    int x = i +dir[k][0];
                    int y = i +dir[k][1];
                    if(x<0||x>=m){
                        continue;
                    }
                    if(y<0||y>=n){
                        continue;
                    }
                    cnt +=(board[x][y]==1||board[x][y]==3)?1:0;
                }
                // 3 11 live live
                // 2 10 die live
                // 1 01 live die
                // 0 00 die die
                if(board[i][j]==1){
                    board[i][j] =(cnt!=2&&cnt!=3)?1:3;// go die
                }
                if(board[i][j] == 0 ){
                    board[i][j] = cnt ==3?2:0;// go live
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]>>= 1;
            }
        }
    }
}
