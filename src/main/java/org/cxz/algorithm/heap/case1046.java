package org.cxz.algorithm.heap;

import org.cxz.algorithm.treepack.case105;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/10 16:57
 */
public class case1046 {
    public static void main(String[] args) {
//        String heapfile ="D://0408.txt";
//        String readfile = case105.readfile(heapfile);
//        String[] arr = readfile.split(" ");
//        int[] ints = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            ints[i] = Integer.valueOf(arr[i]);
//        }
        int[] a = new int[]{2,7,4,1,8,1};

        int i = new case1046().lastStoneWeight2(a);


    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) ->
                o2 - o1);
        for (int stone : stones) {
            priorityQueue.offer(stone);
        }
        while (priorityQueue.size() >= 6) {
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();
            if (x > y) {
                priorityQueue.offer(x - y);
            }
        }
        System.out.println(priorityQueue);
        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }
    public int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->o2-o1);
        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }
        while(pq.size()>1){
            if(pq.size()==1){
                break;
            }
            int a = pq.poll();
            int b = pq.poll();
            int c = Math.abs(a-b);
            pq.offer(c);
        }
        return pq.peek();
    }
}
