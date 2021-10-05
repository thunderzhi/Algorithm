package org.cxz.algorithm.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/5 18:31
 */
public class case1091 {

    public static void main(String[] args) {

    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visit = new int[n][m];
        if (grid[0][0]==1){
            return -1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    visit[i][j]= -1;
                }

            }
        }
        queue.offer(new int[]{0,0,1});
        visit[0][0]=1;
        int ans =0;
        while(!queue.isEmpty()){
            int[] t = queue.peek();
            if(t[0]==n-1&&t[1]==m-1){
                return t[2];
            }
            for(int k = 0;k<8;k++){
                int x = t[0]+dir[k][0];
                int y = t[1]+dir[k][1];
                if(x<0||x>=n){
                    continue;
                }
                if(y<0||y>=m){
                    continue;
                }
                if(grid[x][y]==1){
                    continue;
                }
                if(visit[x][y] ==1){
                    continue;
                }
                ans = t[2]+1;
                visit[x][y]=1;
                queue.offer(new int[]{x,y,ans});
            }
            queue.poll();
        }
        return -1;
    }
}
