package org.cxz.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/6 11:18
 */
public class case456 {
    public static void main(String[] args) {

    }

    public boolean find132pattern(int[] nums) {
        int[] l = new int[nums.length];
        l[0]= Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            l[i] = Math.min(l[i-1],nums[i-1]);
        }
        Deque<Integer> qu  = new LinkedList<>();
        for (int i =nums.length ; i >=0; i--) {
            int val = nums[i];
            while(!qu.isEmpty()&&nums[i]>qu.peekLast()){
                val = qu.pollLast();

            }
            qu.offerLast(nums[i]);
            if(l[i]<nums[i]&&nums[i]>val&&val>l[i]){
                return true;
            }
        }
        return false;
    }
}
