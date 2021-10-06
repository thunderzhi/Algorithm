package org.cxz.algorithm.dynamic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/6 16:36
 */
public class caseO13 {
    public static void main(String[] args) {

    }

    public int movingCount(int m, int n, int k) {
        int[][] visit = new int[m][n];

        if(k==0){
            return 1;
        }

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                int t = bigk(k,i,j);
                visit[i][j] = t==1?-2:-1;//-2 not allow  -1 never visited
                System.out.println("visit["+i+"]["+j+"]="+visit[i][j] );
            }
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        int ans = 0;
        visit[0][0] =1;

        queue.offer(new int[]{0,0,1});
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int[] tmp = queue.peek();
            ans++;
            for(int d = 0;d<4;d++ ){
                int x = tmp[0]+dir[d][0];
                int y = tmp[1]+dir[d][1];
                if(x<0||x>m-1){
                    continue;
                }
                if(y<0||y>n-1){
                    continue;
                }
                if(visit[x][y]==-2||visit[x][y]!=-1){
                    continue;
                }
                visit[x][y]= tmp[2]+1;

                queue.offer(new int[]{x,y,visit[x][y]});
            }
            queue.poll();
        }
        return ans;

    }

    public int bigk(int k,int i,int j){
        int sum =0;
        while(i>0){
            sum +=i%10;
            i/=10;
        }
        while(j>0){
            sum +=j%10;
            j/=10;
        }

        return sum>k?1:0;
    }
}
