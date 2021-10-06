package org.cxz.algorithm.matrix;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/6 21:13
 */
public class case130 {
    public static void main(String[] args) {


    }

    public int n;//column
    public int m;//row
    public int[][] dir ={{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        m = board.length;// row
        n = board[0].length;//column

        for(int i =0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(i,0,board);
            }
            if(board[i][n-1]=='O'){
                dfs(i,n-1,board);
            }
        }
        for(int j =0;j<n;j++){
            if(board[0][j]=='O'){
                dfs(0,j,board);
            }
            if(board[m-1][j]=='O'){
                dfs(m-1,j,board);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='o'){
                    board[i][j]='O';
                }
            }
        }
    }

    public void dfs(int i,int j,char[][] arr){
        arr[i][j]='o';
        for(int k =0;k<4;k++){
            int x = i+dir[k][0];
            int y = j+dir[k][1];
            if(x<0||x>=m||y<0||y>=n){
                continue;
            }
            if(arr[x][y]!='O'){
                continue;
            }
            dfs(x,y,arr);
        }
        return;
    }
}
