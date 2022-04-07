package org.cxz.algorithm.off.I;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/6 17:06
 */
public class caseOff031 {
    //ver1
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length) return false;
        if(pushed.length==0&&popped.length==0) return true;
        Deque<Integer> stack = new LinkedList();
        int lpop = 0,lpush = 0,n = pushed.length;
        while(lpop<n){
            while(stack.isEmpty()||stack.peek()!=popped[lpop]){
                if(lpush>=n) break;
                stack.push(pushed[lpush++]);
            }
            if(stack.peek()!=popped[lpop]) break;
            stack.pop();
            lpop++;
        }
        return stack.isEmpty()&&lpop>=n;
    }
    //ver2
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num
            while(!stack.isEmpty() && stack.peek() == popped[i]) { //
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

}
