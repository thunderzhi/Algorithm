package org.cxz.algorithm.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/30 17:07
 */
public class case864 {

    //region ver 1 compact Bit &&  BFS 3D
    public int[][] dir;
    public boolean[][][] vis;
    public int m,n,cnt;
    public int[] bit=new int[]{1,2,4,8,16,32,64,128};

    public int shortestPathAllKeys(String[] grid) {

        dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        m = grid.length;
        n = grid[0].length();

        vis = new boolean[m][n][130];
        Queue<Integer[]> que = new LinkedList();
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i].charAt(j)=='@'){
                    vis[i][j][0]=true;
                    que.offer(new Integer[]{i,j,0,0});
                }
                else if(grid[i].charAt(j)>='a'
                        &&grid[i].charAt(j)<='z'){
                    cnt++;
                }
            }
        }
        while(!que.isEmpty()){
            Integer[] node = que.poll();
            if(node[2]==(bit[cnt]-1)){
                return node[3];
            }
            for(int d =0;d<4;d++){
                int x = node[0]+dir[d][0];
                int y = node[1]+dir[d][1];
                if(x<0||x>=m||y<0||y>=n||vis[x][y][node[2]]) continue;
                if(grid[x].charAt(y)=='.'||grid[x].charAt(y)=='@'){
                    vis[x][y][node[2]]=true;
                    que.offer(new Integer[]{x,y,node[2],node[3]+1});
                }
                else if(grid[x].charAt(y)>='a'
                        &&grid[x].charAt(y)<='z'){
                    vis[x][y][node[2]]=true;
                    vis[x][y][node[2]|(bit[grid[x].charAt(y)-'a'])]=true;
                    que.offer(new Integer[]{x,y,(node[2]|(bit[grid[x].charAt(y)-'a'])),node[3]+1});
                }else if(grid[x].charAt(y)>='A'
                        &&grid[x].charAt(y)<='Z'
                        &&((node[2]&(bit[grid[x].charAt(y)-'A']))!=0)){
                    vis[x][y][node[2]]=true;
                    que.offer(new Integer[]{x,y,node[2],node[3]+1});
                }
            }
        }
        return -1;
    }
    //endregion
}
