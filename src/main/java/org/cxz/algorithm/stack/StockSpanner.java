package org.cxz.algorithm.stack;

import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/3 10:18
 */
public class StockSpanner {

    Stack<int[]> st;
    int time;
    public StockSpanner() {
        st = new Stack<>();
        time =0;
        int[] bot = {Integer.MAX_VALUE,time};
        st.push(bot);
    }
    // find pre the first greater than cur, monotonic decrease stack
    public int next(int price) {
        while(!st.isEmpty()&&st.peek()[0]<=price){
            st.pop();
        }
        time+=1;
        int[] obj = {price,time};
        int res = obj[1]-st.peek()[1];
        st.push(obj);
        return res;
    }
}
