package org.cxz.algorithm.stack;

import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/3 14:11
 */
public class case793 {
    public static void main(String[] args) {

    }
    // find next greater ,so use monotonic decrease stack
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while(!st.isEmpty()&&temperatures[st.peek()]<temperatures[i]){
                ans[st.peek()] = i- st.peek();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}
