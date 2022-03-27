package org.cxz.algorithm.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/28 0:19
 */
public class case994 {

    //region ver1 by my
    public int m,n,cnt;
    public int[][] dir;
    public int orangesRotting(int[][] grid) {
        dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        cnt =0;
        m = grid.length;
        n = grid[0].length;
        Queue<Integer[]> queue = new LinkedList();
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==1){
                    cnt++;
                }
                if(grid[i][j]==2){
                    queue.offer(new Integer[]{i,j});
                }
            }
        }
        return bfs(grid,queue);
    }

    public int bfs(int[][]grid ,Queue<Integer[]> queue ){
        int ans =0;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0;i<length;i++){
                Integer[] tmp = queue.poll();
                for(int k=0;k<4;k++){
                    int x = tmp[0]+dir[k][0];
                    int y = tmp[1]+dir[k][1];
                    if(x<0||x>=m) continue;
                    if(y<0||y>=n) continue;
                    if(grid[x][y]==0||grid[x][y]==2||grid[x][y]==3 ) continue;//||grid[x][y]==3 is color
                    grid[x][y] =3;
                    queue.offer(new Integer[]{x,y});
                }
            }
            if(refresh(grid)){ ans++;}

        }
        return cnt==0?ans:-1;
    }

    public boolean refresh(int[][]grid){
        boolean flag = false;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==3){
                    grid[i][j]=2;
                    cnt--;
                    flag = true;
                }
            }
        }
        return flag;
    }
    //endregion

}
