package org.cxz.algorithm.stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/3 9:48
 */
public class case503 {
    public static void main(String[] args) {

    }

    // find next greater ,so  use monotonic decreasing stack
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[]  next = new int[nums.length];
        Arrays.fill(next,-1);


        for (int i= 0;i<nums.length;i++){
            while(!st.isEmpty()&&nums[st.peek()]<nums[i]){
                next[st.peek()] = nums[i];
                st.pop();
            }
            st.push(i);
        }
        for (int i= 0;i<nums.length;i++){
            while(!st.isEmpty()&&nums[st.peek()]<nums[i]){
                next[st.peek()] = nums[i];
                st.pop();
            }
            st.push(i);
        }
        return next;
    }




}
