package org.cxz.algorithm.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/5 13:11
 */
public class case542 {
    public static void main(String[] args) {

    }
    public class Data{
        public int i;
        public int j;
        public int val;
        Data(int x, int y,int v){
            i =x;
            j =y;
            val= v;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Data> queue = new LinkedList<Data>();
        int[][] visit = new int[n][m];
        //queue
        //Visit[][]
        initqueue(mat,n,m,queue,visit);
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            Data t = queue.peek();
            for(int k =0;k<4;k++){
                int x = t.i+dir[k][0];
                int y = t.j+dir[k][1];
                if(x<0||y<0||x>n-1||y>m-1){
                    continue;//out of board
                }
                if(visit[x][y]!=-1){
                    continue;// this visited
                }
                visit[x][y] = t.val+1;
                queue.offer(new Data(x,y,visit[x][y]));
            }
            queue.poll();
        }
        return visit;
    }
    public void initqueue(int[][] mat,int n,int m,Queue queue,int[][] visit){
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(mat[i][j]==0){
                    queue.offer(new Data(i,j,0));
                    visit[i][j]=0;
                }
                else{
                    visit[i][j]=-1;
                }
            }
        }
    }
}
