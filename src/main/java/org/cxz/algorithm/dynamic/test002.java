package org.cxz.algorithm.dynamic;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/21 15:06
 */
public class test002 {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        TreeSet<Integer> s  = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            tm.put(arr[i],arr[i]);
            s.add(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i:tm.keySet()){
            sb.append(" , "+i);
        }
        System.out.println("map out   " + sb.toString());
        sb = new StringBuilder();
        for (Integer i:s) {
            sb.append(" , "+i);
        }
        System.out.println("tset out   " + sb.toString());
        s.ceiling(1);
    }
}
