package org.cxz.algorithm.koj;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/13 16:35
 */
public class jcase104 {
    public static void main(String[] args) {

    }

    public void f104(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])){
                continue;
            }
            q.offer(arr[i]);
            set.add(arr[i]);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(q.poll());
        while (!q.isEmpty()){
            sb.append(" "+q.poll());
        }
        System.out.println(sb.toString());
    }
}
