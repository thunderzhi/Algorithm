package org.cxz.algorithm.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/28 0:28
 */
public class case529 {
    //region  ver1 bymy
    public int m ,n ;
    public int[][] dir;
    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1},
                {1,1},{-1,-1},{-1,1},{1,-1}};
        Queue<Integer[]> queue = new LinkedList();
        queue.offer(new Integer[]{click[0],click[1]});
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        int cnt = getcnt(click[0],click[1],board);
        if(cnt>0){
            board[click[0]][click[1]]=(char)(cnt+'0');
            return board;
        }
        board[click[0]][click[1]]='B';
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0;i<length;i++){
                Integer[] tmp = queue.poll();
                int x = tmp[0];
                int y = tmp[1];
                for(int d =0;d<8;d++){
                    int xx = x +dir[d][0];
                    int yy = y +dir[d][1];
                    if(xx<0||xx>=m) continue;
                    if(yy<0||yy>=n) continue;
                    if(board[xx][yy]=='B')continue;
                    if(board[xx][yy]>'0'&&board[xx][yy]<'9')continue;
                    cnt = getcnt(xx,yy,board);
                    if(cnt==0){
                        board[xx][yy]='B';
                        queue.offer(new Integer[]{xx,yy});
                    }
                    else{
                        board[xx][yy]=(char)(cnt+'0');
                    }
                }
            }
        }

        return board;
    }
    public int getcnt(int i,int j,char[][] board){
        int cnt =0;
        for(int k =0;k<8;k++){
            int x = i+dir[k][0];
            int y = j+dir[k][1];
            if(x<0||x>=m) continue;
            if(y<0||y>=n) continue;
            if(board[x][y]=='M'){
                cnt++;
            }
        }
        return cnt;
    }
    //endregion
}
