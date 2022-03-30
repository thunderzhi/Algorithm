package org.cxz.algorithm.matrix;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/30 17:05
 */
public class case1631 {

    //region Ver 1 DFS+ BinarySearch
    public int[][] dir;
    public int m,n,ans;

    public int minimumEffortPath(int[][] heights) {
        dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        m = heights.length;
        n = heights[0].length;
        if(m==1&&n==1) return 0;
        return binarysearch(heights);
    }
    public int binarysearch(int[][] heights){
        int l=0, r = 1000000;
        int mid =0;
        while(l<r){
            mid = l+(r-l)/2;
            if(calldfs(heights, 0,0,mid)){
                r = mid;
            }
            else{
                l = mid+1;
            }
            //System.out.println("mid: "+mid);
        }
        return l ;
    }
    public boolean calldfs(int[][] heights,int x,int y,int cost){
        boolean[][] vis = new  boolean[m][n];
        vis[0][0] =true;
        return dfs(heights,vis,0,0,cost);
    }

    public boolean dfs(int[][] heights,boolean[][] vis ,int x,int y,int cost){
        if(x==m-1&&y==n-1){
            return true;
        }
        for(int k = 0;k<4;k++){
            int xx = x + dir[k][0];
            int yy = y + dir[k][1];
            if(xx>=m||xx<0) continue;
            if(yy>=n||yy<0) continue;
            if(vis[xx][yy]) continue;
            if(Math.abs(heights[x][y]-heights[xx][yy])>cost) continue;
            vis[xx][yy] = true;
            if(dfs(heights,vis,xx,yy, cost)){
                return true;
            }
        }
        return false;
    }
    //endregion




}
