package org.cxz.contest.test337week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/3/19 10:26
 */
public class test0319b {
//    int[][] dir = new int[][]{};
    int[][] dir = {{2,1},{1,2},{-2,1},{-1,2},{2,-1},{1,-2},{-2,-1},{-1,-2}};
    int n;
    public int getidx(int x,int y){
        return x*n+y;
    }
    public boolean checkValidGrid(int[][] grid) {
        n = grid.length;
        if(grid[0][0]!=0) return false;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = getidx(i,j);
                int v = grid[i][j];
                list.add(new int[]{v,idx});
            }
        }
        Collections.sort(list,(a,b)->{
            return a[0]-b[0];
        });

        for (int i = 0; i < list.size(); i++) {
            if(i==list.size()-1) break;
            int cur = list.get(i)[1];
            int nx = list.get(i+1)[1];
            int x = cur/n,y = cur%n;
            int nxx = nx/n,nyy = nx%n;
            boolean flag = false;
            for (int j = 0; j < 8; j++) {
                int xx = x+dir[j][0];
                int yy = y+dir[j][1];
                if(xx<0||xx>n-1) continue;
                if(yy<0||yy>n-1) continue;
                if(xx==nxx&&yy==nyy){
                    flag= true;
                    break;
                }
            }
   System.out.println("i:"+i+" curx  = " + (cur/n)+" cury= "+(cur%n) + " nx x : "+(nx/n)+" nx y : "+(nx%n)+ " is :"+flag);

            if(!flag) return false;
        }
        return true;
    }
}
