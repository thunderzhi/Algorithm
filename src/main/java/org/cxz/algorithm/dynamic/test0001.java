package org.cxz.algorithm.dynamic;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/14 16:10
 */
public class test0001 {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        TreeMap<Integer,Integer> tmap =new TreeMap<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            int v = random.nextInt(100);
            System.out.println("insert v = " + v);
            s.add(v);
            map.put(v,v);
            tmap.put(v,v);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : s){
            sb.append(" , "+i);
        }
        System.out.println("out   " + sb.toString());
        sb = new StringBuilder();
        for (Integer i:map.keySet()){
            sb.append(" , "+i);
        }
        System.out.println("map out   " + sb.toString());
        sb = new StringBuilder();
        int cnt =0;
        for (Integer i:tmap.keySet()){
            sb.append(" , "+i);
            System.out.println(i+" low key = " + tmap.lowerKey(i));
            cnt++;
        }
        System.out.println("tmap out   " + sb.toString());



    }


}
