package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/23 12:09
 */
public class case056 {

    //ver 1 cap
    public int[][] merge(int[][] intervals) {
        int[][] list = new int[intervals.length*2][2];
        for(int i=0,k=0;i<intervals.length;i++){
            int[] inter= intervals[i];
            list[k++] = new int[]{inter[0],1};
            list[k++] = new int[]{inter[1],-1};
        }
        Arrays.sort(list,(a,b)->{
            return a[0]==b[0]?b[1]-a[1]:a[0]-b[0];
        });
        List<int[]> res = new ArrayList();
        int pre = -1,cnt=0;
        for (int i =0;i<list.length; i++) {
            int[] t = list[i];
            if(pre==-1) pre = t[0];
            cnt += t[1];
            if(cnt==0){
                res.add(new int[]{pre,t[0]});
                pre=-1;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    // ver2 assist
    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
