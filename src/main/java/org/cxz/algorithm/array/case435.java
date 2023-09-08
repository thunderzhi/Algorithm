package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/8 20:26
 */
public class case435 {


    public int eraseOverlapIntervals(int[][] intervals) {
        int pre = Integer.MIN_VALUE,n = intervals.length;
        Arrays.sort(intervals,(int[] a, int[] b)->{
            return a[1]-b[1];
        });
        int ans =0;
        for(int[] item:intervals){
            if(item[0]<pre) continue;
            pre = item[1];
            ans++;
        }
        return n-ans;
    }

}
