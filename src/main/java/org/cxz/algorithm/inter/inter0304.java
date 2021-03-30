package org.cxz.algorithm.inter;

import javax.lang.model.element.VariableElement;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/21 10:24
 */
public class inter0304 {
    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int peek = myQueue.peek();
        int pop = myQueue.pop();
        boolean empty = myQueue.empty();

    }
    static class MyQueue {
        Stack<Integer> s1;//in
        Stack<Integer> s2;//out

        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
            return;
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {

            transfer();
            return s2.pop();
        }

        public void transfer(){
            if(!s2.isEmpty()){
                return;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return;
        }


        /** Get the front element. */
        public int peek() {

            transfer();
            return s2.peek();

        }

        /** Returns whether the queue is empty. */
        public boolean empty() {

            return s1.isEmpty()&&s2.isEmpty();

        }
    }

}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */