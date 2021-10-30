package org.cxz.algorithm.off;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/30 21:43
 */
public class caseO59 {
    public static void main(String[] args) {

    }
    Deque<Integer> q;
    Deque<Integer> mq;
    public MaxQueue() {
        q = new LinkedList<>();
        mq = new LinkedList<>();

    }
    public int max_value() {
        if(mq.isEmpty()){
            return -1;
        }
        return mq.peekFirst();
    }

    public void push_back(int value) {
        q.offer(value);
        while(!mq.isEmpty()&&mq.peekLast()<value ){
            mq.pollLast();
        }
        mq.offer(value);
    }

    public int pop_front() {
        if(q.isEmpty()){
            return -1;
        }
        int t = q.poll();
        if(t==mq.peek()){
            mq.poll();
        }
        return t;
    }
}
