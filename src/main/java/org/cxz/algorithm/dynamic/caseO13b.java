package org.cxz.algorithm.dynamic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/6 16:36
 */
public class caseO13b {
    public static void main(String[] args) {

    }

    public int movingCount(int m, int n, int k) {

        if(k==0){
            return 1;
        }
        int[] dum = new int[100];
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j < 10; j++) {
                dum[i*10+j]=i+j;
            }
        }
        HashSet<Integer> set = new HashSet<>();

        Queue<int[]> queue = new LinkedList<int[]>();
        int ans = 0;
        set.add(0);
        queue.offer(new int[]{0,0});
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
                if(set.contains(x*n+y)){
                    continue;
                }
                if(dum[x]+dum[y]>k){
                    continue;
                }
                set.add(x*n+y);
                queue.offer(new int[]{x,y});
            }
            queue.poll();
        }
        return ans;

    }


}
