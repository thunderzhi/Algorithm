package org.cxz.algorithm.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/19 23:08
 */
public class test1111111 {

    public static void main(String[] args) {
        new ArrayList();
        PriorityQueue<Double> pq = new PriorityQueue<Double>((o1, o2)->{return o2.compareTo(o1);});
        Integer[] ind = new Integer[12];
        int[] prices= new int[12];
        Arrays.sort(ind,(o1, o2)->{
            return prices[o1]-prices[o2];
        });
    }
}
