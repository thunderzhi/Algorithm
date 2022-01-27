package org.cxz.algorithm.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/27 15:16
 */
public class case502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Integer[] ind = new Integer[capital.length];
        for(int i=0;i<ind.length;i++){
            ind[i]=i;
        }
        //sort by capital
        Arrays.sort(ind, 0, ind.length , new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return capital[o1]-capital[o2];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                new Comparator<Integer>(){
                    @Override
                    public int compare(Integer o1,Integer o2){
                        return o2-o1;
                    }
                }
        );
        int start =0;
        for(;k>0;k--){
            while(start<ind.length&&w>=capital[ind[start]]){
                pq.offer(profits[ind[start]]);//miss profit
                start++;
            }
            if(pq.size()==0){break;}
            w+= pq.poll();
        }
        return w;
    }


    public int findMaximizedCapital2(int k, int w, int[] profits, int[] capital) {
        Integer[] ind = new Integer[capital.length];
        for(int i=0;i<ind.length;i++){
            ind[i]=i;
        }
        //sort by capital
        Arrays.sort(ind, (o1,o2)->{return capital[o1]-capital[o2];});
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->{return o2-o1;});
        int start =0;
        for(;k>0;k--){
            while(start<ind.length&&w>=capital[ind[start]]){
                pq.offer(profits[ind[start]]);//miss profit
                start++;
            }
            if(pq.size()==0){break;}
            w+= pq.poll();
        }
        return w;
    }
}
