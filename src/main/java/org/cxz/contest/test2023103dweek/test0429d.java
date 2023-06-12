package org.cxz.contest.test2023103dweek;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/29 22:20
 */
public class test0429c {
    int m ,n;
    public int getidx(int x,int y){
        return x*m+y;
    }
    public int[] getCor(int x){
        return new int[]{x/m,x%m};
    }
    public int findMaxFish(int[][] grid) {
        m = grid.length;
        n= grid[0].length;
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        List<Integer> fisharea = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0)continue;
                fisharea.add(getidx(i,j));
            }
        }
        System.out.println("fisharea = " + fisharea.size());
        int ans = 0;
        for (int i = 0; i < fisharea.size(); i++) {
            int[] cor = getCor(fisharea.get(i));
            System.out.println("fisharea.get(i) = " + fisharea.get(i));
            System.out.println("cor[0] = " + cor[0]);
            System.out.println("cor[1] = " + cor[1]);
            if(grid[cor[0]][cor[1]]<0) continue;
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(cor);
            int sum = 0;
            while(!queue.isEmpty()){
                int l = queue.size();
                for (int j = 0; j < l; j++) {
                    int[] it = queue.poll();
                    int x = it[0],y = it[1];
                    sum += grid[x][y];
                    grid[x][y]=-1;
                    for (int k = 0; k < 4; k++) {
                        int xx = x + dirs[k][0];
                        int yy = y + dirs[k][1];
                        if(xx<0||xx>=m) continue;
                        if(yy<0||yy>=n) continue;
                        if(grid[xx][yy]<=0) continue;
                        queue.offer(new int[]{xx,yy});
                    }
                }
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
