package org.cxz.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: contest108 Q4
 * @date 2023/7/14 12:14
 */
public class case2768 {
    class Solution {
        long row,col;
        public long getIdx(long x,long y){
            return x*col+y;
        }
        public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
            this.row = (long)m;
            this.col = (long)n;
            Map<Long,Integer> map = new HashMap();
            long[] ans = new long[5];
            ans[0] = ((long)(n-1)*(long)(m-1));
            for(int[] coor: coordinates){
                long x = (long)coor[0],y = (long)coor[1];
                // 1
                if(x+1<m&&y+1<n){
                    long id = getIdx(x,y);
                    map.put(id,map.getOrDefault(id,0)+1);
                }
                if(x+1<m&&y-1>=0){
                    long id = getIdx(x,y-1);
                    map.put(id,map.getOrDefault(id,0)+1);
                }
                if(x-1>=0&&y+1<n){
                    long id = getIdx(x-1,y);
                    map.put(id,map.getOrDefault(id,0)+1);
                }
                if(x-1>=0&&y-1>=0){
                    long id = getIdx(x-1,y-1);
                    map.put(id,map.getOrDefault(id,0)+1);
                }
            }
// System.out.println(" ans : "+Arrays.toString(ans));
            for(long k: map.keySet()){
                int cnt = map.get(k);
                ans[cnt]++;
            }
// System.out.println(" ans : "+Arrays.toString(ans));
            for(int i = 1;i<5;i++){
                ans[0] -= ans[i];
            }

            return ans;
        }
    }
}
