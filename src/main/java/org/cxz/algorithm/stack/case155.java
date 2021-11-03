package org.cxz.algorithm.stack;

import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/8/25 17:23
 */
public class case155 {

    public Stack<Integer> stack;
    public Stack<Integer> minstack;
    public case155() {
        stack = new Stack<>();
        minstack = new Stack<>();//save min
    }

    public void push(int val) {
        stack.push(val);
        if (minstack==null||minstack.peek()>=val)
        {
            minstack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int pop = (int)stack.pop();
        if (minstack.peek()==pop){
            minstack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return  minstack.peek();
    }
}
