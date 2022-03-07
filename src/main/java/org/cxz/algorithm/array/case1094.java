package org.cxz.algorithm.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/7 22:42
 */
public class case1094 {

    // ver 1 priorityqueue
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(int[] o1, int[] o2)->{ return o1[1]-o2[1]; });
        PriorityQueue<Integer> pqstop = new PriorityQueue<Integer>(
                (o1,o2)->{return trips[o1][2]-trips[o2][2]; }
        );

        for(int i =0; i<trips.length ; i++ ){
            int[] item = trips[i];
            capacity -= item[0];
            if(capacity<0){
                while(!pqstop.isEmpty()&&trips[pqstop.peek()][2]<=item[1]) capacity += trips[pqstop.poll()][0];
                if(capacity<0) return false;
            }
            pqstop.offer(i);
        }
        return true;
    }

    //ver 2
    public boolean carPooling2(int[][] trips, int capacity) {
        int[] dis = new int[10005];
        for(int[] item: trips){
            int cnt = item[0];
            int on = item[1];
            int off = item[2];
            dis[on] -= cnt;
            dis[off] += cnt;
        }

        for(int i = 0;i< dis.length;i++){
            capacity+=dis[i];
            if(capacity<0) return false;
        }
        return true;
    }
}