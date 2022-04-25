package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/23 17:16
 */
public class case1288 {

    //ver 1 bymy
    public int removeCoveredIntervals(int[][] intervals) {
        int total = intervals.length;
        Arrays.sort(intervals,(a, b)->{
            return a[0]==b[0]?b[1]-a[1]:a[0]-b[0];
        });
        int[] pre =new int[]{-1,-1};
        for(int i = 0;i<intervals.length ;i++){
            int[] cur =  intervals[i];
            if(pre[0]==-1){
                pre = cur;
                continue;
            }
            if(pre[0]<=cur[0]&&pre[1]>=cur[1]){
                total--;
            }
            else{
                pre= cur;
            }
        }
        return total;
    }

    //ver2
    public int removeCoveredIntervals2(int[][] intervals) {
        int total = intervals.length;
        Arrays.sort(intervals,(a,b)->{
            return a[0]==b[0]?b[1]-a[1]:a[0]-b[0];
        });
        int cnt=0,pre=-1;
        for(int[] cur:intervals){
            if(pre>=cur[1]) cnt++;
            pre = Math.max(pre,cur[1]);
        }
        return total-cnt;
    }
}
