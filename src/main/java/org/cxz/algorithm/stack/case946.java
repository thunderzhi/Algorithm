package org.cxz.algorithm.stack;

import javax.swing.text.rtf.RTFEditorKit;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/21 15:42
 */
public class case946 {

    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int j=0;
        for (int i = 0; i < popped.length; i++) {
            //focus on out stack,
            //if popped stack top not equal pushed e ,push e until find e equal poped top
            //then s.pop,
            while (j<pushed.length&&(!s.isEmpty()||s.peek()!=popped[i])){
                s.push(pushed[j]);
                j+=1;
            }
            if (s.peek()!=popped[i]){
                return false;
            }
            s.pop();
        }
        return true;

    }
}
