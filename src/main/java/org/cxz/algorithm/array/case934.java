package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/6 23:03
 */
public class case934 {
    public int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans =0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                    while(!bfs(grid)){
                        ans++;
                    }
                    return ans;
                }
            }
        }
        return ans;
    }

    public boolean color(int[][] grid,int i,int j){
        if(i<0||i>=grid.length) return false ;
        if(j<0||j>=grid[0].length) return false;
        if(grid[i][j]==1) return true;
        if(grid[i][j]==0){
            grid[i][j]=3;
        }
        return false;
    }

    public boolean bfs(int[][] grid){
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    if(color(grid,i+1,j)||color(grid,i-1,j)
                            ||color(grid,i,j+1)||color(grid,i,j-1)){
                        return true;
                    }
                }
            }
        }

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==3) grid[i][j]=2;
            }
        }
        return false;
    }

    public void dfs(int[][] grid,int i,int j){
        if(grid[i][j]!=1) return;
        grid[i][j] =2;
        for(int[] d :dir){
            int x = i+d[0];
            int y = j+d[1];
            if(x<0||x>=grid.length) continue ;
            if(y<0||y>=grid[0].length) continue ;
            dfs(grid,x,y);
        }
        return;
    }
}
