package org.cxz.algorithm.contest;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/16 15:03
 */
public class casetest1 {

    public static void main(String[] args) {
        int[] a = new int[]{100,0,50,100};
        int[][] b = new int[][]{{0,2},{0,1},{3,0},{3,0}};
        int i = new casetest1().giveGem(a, b);
        System.out.println("i = " + i);
    }
    public int giveGem(int[] gem, int[][] operations) {

        PriorityQueue<Integer> small = new PriorityQueue<Integer>((o1,o2)->{return gem[o1]-gem[o2];});
        PriorityQueue<Integer> big = new PriorityQueue<Integer>((o1,o2)->{ return gem[o2]-gem[o1];});
        for(int i =0;i<gem.length;i++){
            small.offer(i);
            big.offer(i);
        }

        for (int i = 0; i < operations.length; i++) {
            int[] item = operations[i];
            int from = item[0];
            int to = item[1];
            gem[to] += gem[from]/2;

            System.out.println("i = " + i);
            System.out.println("gem[to] = " + gem[to]);

            gem[from] = gem[from] - gem[from]/2;
            System.out.println("gem[from] = " + gem[from]);
            System.out.println("Arrays.toString(gem) = " + Arrays.toString(gem));

        }
        return gem[big.peek()]  - gem[small.peek()] ;
    }
}
