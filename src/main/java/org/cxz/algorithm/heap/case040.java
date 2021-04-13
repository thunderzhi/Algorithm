package org.cxz.algorithm.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/13 17:43
 */
public class case040 {
    public static void main(String[] args) {

        int[] a = new int[]{3,2,1};
        int k = 2;
        int[] leastNumbers = new case040().getLeastNumbers(a, k);
        System.out.println(Arrays.toString(leastNumbers));
        //System.out.println(leastNumbers);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        if(k==0){
            return new int[]{};
        }
        if(arr.length<=0){
            return new int[]{};
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2)->o2-o1);
        for (int i = 0; i < arr.length; i++) {
            if (pq.size()<k){
                pq.offer(arr[i]);
                continue;
            }
            if (arr[i]< pq.peek()) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i]=pq.poll();
        }
        return ans;
    }
}
