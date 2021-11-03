package org.cxz.algorithm.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/3 14:55
 */
public class case84 {
    public static void main(String[] args) {
        int[] arr = {2,4,4,4,4,2};


        int res = new case84().largestRectangleArea(arr);
        System.out.println("res = " + res);
    }

    public int largestRectangleArea(int[] heights) {
        int[] pre = new int[heights.length];
        int[] next = new int[heights.length];
        int n = heights.length ;
        for (int i = 0; i < heights.length; i++) {
            pre[i] = -1;
            next[i] = n;

        }
        // mono increase
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty()&&heights[i]<= heights[stack.peekLast()]){
                next[stack.peekLast()] = i;
                System.out.println("i = " + i);
                System.out.println(" heights = " + Arrays.toString(heights));
                System.out.println(" next = " + Arrays.toString(next));
                System.out.println(" stack = " + stack.toString());

                stack.pollLast();
            }
            if(!stack.isEmpty()){
                pre[i] = stack.peekLast();
            }
            System.out.println(" pre = " + Arrays.toString(pre));
            stack.offerLast(i);
        }
        int ans =0;
        for (int i = 0; i < heights.length; i++) {
            int t = heights[i]*(next[i]-pre[i]-1);
            System.out.println("next["+i+"]= " + next[i]+" pre["+i+"]= "+pre[i]+" width = "+(next[i]-pre[i]-1));
            System.out.println(" ans = " + ans+" t = " +t);
            ans = Math.max(ans,t);
        }
        return ans;
    }
}
