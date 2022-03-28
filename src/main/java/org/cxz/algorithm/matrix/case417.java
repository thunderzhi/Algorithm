package org.cxz.algorithm.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/28 15:54
 */
public class case417 {

    //region ver 1 BFS
    public int[][] dir;
    public int m ,n ;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        List<List<Integer>> ans = new ArrayList();
        m  = heights.length;
        n  = heights[0].length;
        //1 -- pacific   2----atlantic
        int[][] mark = new int[m][n];

        bfs(heights,mark,1,ans);
        bfs(heights,mark,2,ans);
        return ans;
    }

    public void bfs(int[][] heights,int[][] mark, int type,List<List<Integer>> ans){
        Queue<Integer[]> queue = new LinkedList();
        if(type==1){
            for(int i=0;i<n;i++){
                queue.offer(new Integer[]{0,i,heights[0][i]});
            }
            for(int i=0;i<m;i++){
                queue.offer(new Integer[]{i,0,heights[i][0]});
            }
        }
        else{
            for(int i=0;i<n;i++){
                queue.offer(new Integer[]{m-1,i,heights[m-1][i]});
            }
            for(int i=0;i<m;i++){
                queue.offer(new Integer[]{i,n-1,heights[i][n-1]});
            }
        }
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0;i<length;i++){
                Integer[] tmp = queue.poll();
                if((mark[tmp[0]][tmp[1]]&type)!=0) continue;// visited
                mark[tmp[0]][tmp[1]]|=type;
                if(mark[tmp[0]][tmp[1]]==3){
                    List<Integer> list = new ArrayList();
                    list.add(tmp[0]);
                    list.add(tmp[1]);
                    ans.add(list);
                }
                for(int d= 0;d<4;d++){
                    int x = tmp[0] + dir[d][0];
                    int y = tmp[1] + dir[d][1];
                    if(x<0||x>=m) continue;
                    if(y<0||y>=n) continue;
                    if(heights[x][y]>=tmp[2]){
                        queue.offer(new Integer[]{x,y,heights[x][y]});
                    }
                }
            }
        }
        return;
    }
    //endregion


    //region DFS
    //ver2 DFS
    public List<List<Integer>> pacificAtlantic2(int[][] heights) {
        dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        List<List<Integer>> ans = new ArrayList();
        m  = heights.length;
        n  = heights[0].length;
        //1 -- pacific   2----atlantic
        int[][] mark = new int[m][n];
        for(int i=0;i<n;i++){
            dfs(heights,mark,0,i,1,ans);
            dfs(heights,mark,m-1,i,2,ans);
        }
        for(int i=0;i<m;i++){
            dfs(heights,mark,i,0,1,ans);
            dfs(heights,mark,i,n-1,2,ans);
        }
        return ans;
    }
    public void dfs(int[][] heights,int[][] mark,int x,int y, int type,List<List<Integer>> ans){
        if((mark[x][y]&type)!=0) return;
        mark[x][y]|=type;
        if(mark[x][y]==3){
            List<Integer> list = new ArrayList();
            list.add(x);
            list.add(y);
            ans.add(list);
        }
        for(int d= 0;d<4;d++){
            int xx = x + dir[d][0];
            int yy = y + dir[d][1];
            if(xx<0||xx>=m) continue;
            if(yy<0||yy>=n) continue;
            if(heights[xx][yy]>=heights[x][y]){
                dfs(heights,mark,xx,yy,type,ans);
            }
        }
        return;
    }
    //endregion



}
